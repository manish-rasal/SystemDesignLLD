package main.java.LLD.RateLimiter;

import java.util.Scanner;

public class RateLimiterFactory {
    public static void main(String[] args) {
        TokenBucketRateLimiter tokenBucketRateLimiter = new TokenBucketRateLimiter(5, 1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter userId");
        String userId = sc.nextLine();
        while(true) {
            System.out.println("Make request?");
            String userChoice = sc.nextLine();
            if(userChoice.equalsIgnoreCase("yes")) {
                if (tokenBucketRateLimiter.allowRequest(userId)) {
                    System.out.println("Request Consumed");
                } else {
                    System.out.println("HTTP 429: Too may requests");
                }
            } else {
                break;
            }
        }
    }
}
