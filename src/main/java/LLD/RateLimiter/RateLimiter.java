package main.java.LLD.RateLimiter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
