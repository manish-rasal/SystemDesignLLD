package main.java.LLD.LRUCache;

import java.util.Scanner;

public class TestLRUCache {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(3);

        while(true) {
            System.out.println("Please choose the operation (get/put): ");
            String operation = scanner.next();
            if (operation.equalsIgnoreCase("get")) {
                System.out.println("Please Enter Key: ");
                Integer key = scanner.nextInt();
                if (lruCache.get(key) == null) {
                    System.out.println("Key doesn't exist");
                } else {
                    System.out.println("Value: " + lruCache.get(key));
                }
            } else {
                System.out.println("Please Enter Key: ");
                Integer key = scanner.nextInt();
                System.out.println("Please Enter Value: ");
                Integer value = scanner.nextInt();
                lruCache.put(key, value);
            }
        }
    }
}
