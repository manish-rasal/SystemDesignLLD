package main.java.LLD.RateLimiter;

public class LeakyBucket {
    private final int capacity;
    private final int leakRate;

    private double water;
    private long lastLeakTime;

    public LeakyBucket(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        water = 0;
        lastLeakTime = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        leak();
        if(water < capacity) {
            water++;
            return true;
        }
        return false;
    }

    private void leak() {
        long now = System.nanoTime();
        double leakedWater = (now - lastLeakTime) / 1e9 * leakRate;
        water = Math.max(0, water - leakedWater);
        lastLeakTime = now;
    }
}
