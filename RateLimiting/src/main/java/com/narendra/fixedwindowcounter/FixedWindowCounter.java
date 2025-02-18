package com.narendra.fixedwindowcounter;

import java.time.Instant;

public class FixedWindowCounter {
    private final long windowSizeInSeconds;
    private final int maxReqPerWindow;
    private Instant currentWindowStartTime;
    private int requestCount;

    public FixedWindowCounter(long windowSizeInSeconds, int maxReqPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxReqPerWindow = maxReqPerWindow;
        this.currentWindowStartTime = Instant.now();
        this.requestCount = 0;
    }

    public synchronized boolean allowRequest() {
        resetWindow();

        if(requestCount < maxReqPerWindow) {
            requestCount ++;
            return true;
        }

        return false;
    }

    private void resetWindow() {
        Instant now = Instant.now();

        if(now.getEpochSecond() - currentWindowStartTime.getEpochSecond() > windowSizeInSeconds) {
            //Moving to next window
            this.requestCount = 0;
            this.currentWindowStartTime = now;
        }
    }
}
