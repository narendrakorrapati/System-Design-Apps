package com.narendra.tokenbucket;

import java.time.Instant;

public class TokenBucket {
    private final int capacity;
    private final int refillRatePerSecond;
    private int tokens;
    private Instant lastRefillTime;

    public TokenBucket(int capacity, int refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.tokens = capacity;
        this.lastRefillTime = Instant.now();
    }

    private void refill() {
        Instant now = Instant.now();
        int diffInSeconds = (int) (now.getEpochSecond() - lastRefillTime.getEpochSecond());
        this.tokens = Math.min(capacity, tokens + (diffInSeconds * refillRatePerSecond));
        this.lastRefillTime = now;
    }

    public synchronized boolean allowRequest() {
        refill();
        if(tokens > 0) {
            tokens --;
            return true;
        }
        return false;
    }
}
