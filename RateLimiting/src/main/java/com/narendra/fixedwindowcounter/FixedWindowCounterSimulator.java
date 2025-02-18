package com.narendra.fixedwindowcounter;

import com.narendra.leakybucket.LeakyBucket;

public class FixedWindowCounterSimulator {

    public static void main(String[] args) throws InterruptedException {
        FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(1, 10);

        for(int i = 1;i <= 50;i ++) {
            boolean status = fixedWindowCounter.allowRequest();
            System.out.println("Request " + i + ":" + status);

            if(!status) {
                Thread.sleep(1000);
            }
        }
    }
}
