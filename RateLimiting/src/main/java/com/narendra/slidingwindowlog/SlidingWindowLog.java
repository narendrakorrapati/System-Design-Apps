package com.narendra.slidingwindowlog;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowLog {
    private final long windowSizeInSeconds;
    private final int maxRequestsInWindow;
    private final Queue<Long> requestLog;

    public SlidingWindowLog(long windowSizeInSeconds, int maxRequestsInWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestsInWindow = maxRequestsInWindow;
        this.requestLog = new ArrayDeque<>();
    }

    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        long windowStart = now - windowSizeInSeconds;

        while(!requestLog.isEmpty() && requestLog.peek() <= windowStart) {
            requestLog.poll();
        }

        if(requestLog.size() < maxRequestsInWindow) {
            requestLog.offer(now);
            return true;
        }

        return false;
    }
}
