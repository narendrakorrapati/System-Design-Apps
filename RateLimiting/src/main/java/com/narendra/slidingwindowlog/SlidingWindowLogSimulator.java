package com.narendra.slidingwindowlog;

public class SlidingWindowLogSimulator {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowLog slidingWindowLog = new SlidingWindowLog(1, 10);

        for(int i = 1;i <= 50;i ++) {
            boolean status = slidingWindowLog.allowRequest();
            System.out.println("Request " + i + ":" + status);

            if(!status) {
                Thread.sleep(1000);
            }
        }
    }
}
