package main.java.LLD.RateLimiter;

public class TokenBucket {
    private final int capacity;
    private final int refillRate;

    private double tokens;
    private long lastRefillTimestamp;

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = capacity;
        this.tokens = capacity;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean tryConsume() {
        refill();
        if(tokens >= 1) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTimestamp) / (1e9 * 60) * refillRate;
        tokens = Math.min(capacity, tokensToAdd + tokens);
        lastRefillTimestamp = now;
    }
}
