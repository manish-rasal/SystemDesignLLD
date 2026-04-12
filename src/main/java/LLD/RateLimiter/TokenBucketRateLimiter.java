package main.java.LLD.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter {
    private final ConcurrentHashMap<String, TokenBucket> userBucketMap;
    private final int capacity;
    private final int refillRate;

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.userBucketMap = new ConcurrentHashMap<>();
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    @Override
    public boolean allowRequest(String userId) {
        userBucketMap.putIfAbsent(userId, new TokenBucket(capacity, refillRate));
        return userBucketMap.get(userId).tryConsume();
    }
}
