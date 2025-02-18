package com.narendra.leakybucket;

import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LeakyBucket {
    private final int capacity;
    private final int leakRatePerSecond;
    private final Queue<Instant> bucket;

    public LeakyBucket(int capacity, int leakRatePerSecond) {
        this.capacity = capacity;
        this.leakRatePerSecond = leakRatePerSecond;
        this.bucket = new ConcurrentLinkedDeque<>();

        new Thread(this::leak).start();
    }

    private void leak() {
        //We are given leak rate per second. example: 5 requests leak per second.
        //Compute process time per request. 1 request leak in 200 milli seconds.
        while (true) {
            try {
                Thread.sleep(1000/leakRatePerSecond); //One request is processed for every 200 millis
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(!bucket.isEmpty()) {
                bucket.poll();
            }
        }
    }

    public synchronized boolean allowRequest() {
        Instant now = Instant.now();

        if(bucket.size() < capacity) {
            bucket.offer(now);
            return true;
        }
        return false;
    }
}
