package main.java.LLD.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class LeakyBucketRateLimiter implements RateLimiter{
    private final ConcurrentHashMap<String, LeakyBucket> userBucketMap;
    private final int capacity;
    private final int leakRate;

    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        userBucketMap = new ConcurrentHashMap<>();
    }


    @Override
    public boolean allowRequest(String userId) {
        userBucketMap.putIfAbsent(userId, new LeakyBucket(capacity, leakRate));
        return userBucketMap.get(userId).allowRequest();
    }
}
