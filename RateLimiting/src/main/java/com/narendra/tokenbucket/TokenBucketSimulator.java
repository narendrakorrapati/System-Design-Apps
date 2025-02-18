package com.narendra.tokenbucket;

public class TokenBucketSimulator {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(10, 5);

        for(int i = 1;i <= 50;i ++) {
            boolean status = tokenBucket.allowRequest();
            System.out.println("Request " + i + ":" + status);

            if(!status) {
                Thread.sleep(1000);
            }
        }
    }
}
