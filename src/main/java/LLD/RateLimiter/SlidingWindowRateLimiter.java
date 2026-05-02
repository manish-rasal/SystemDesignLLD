package main.java.LLD.RateLimiter;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter implements RateLimiter {

    private final ConcurrentHashMap<String, Deque<Long>> userRequestMap;
    private final int maxRequests;
    private final long windowSize;

    public SlidingWindowRateLimiter(int maxRequests, long windowSize) {
        this.userRequestMap = new ConcurrentHashMap<>();
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
    }

    @Override
    public boolean allowRequest(String userId) {
        userRequestMap.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> requestQueue = userRequestMap.get(userId);

        synchronized (requestQueue) {
            long now = System.currentTimeMillis();
            while(!requestQueue.isEmpty() && (now - requestQueue.peekFirst()) > windowSize) {
                requestQueue.pollFirst();
            }

            if(requestQueue.size() < maxRequests) return true;
        }
        return false;
    }
}
