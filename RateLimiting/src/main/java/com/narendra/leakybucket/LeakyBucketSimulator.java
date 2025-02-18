package com.narendra.leakybucket;

public class LeakyBucketSimulator {

    public static void main(String[] args) throws InterruptedException {
        LeakyBucket leakyBucket = new LeakyBucket(10, 5);

        for(int i = 1;i <= 50;i ++) {
            boolean status = leakyBucket.allowRequest();
            System.out.println("Request " + i + ":" + status);

            if(!status) {
                Thread.sleep(1000);
            }
        }
    }
}
