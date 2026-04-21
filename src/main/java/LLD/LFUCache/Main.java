package main.java.LLD.LFUCache;

import main.java.LLD.LRUCache.LRUCache;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LFUCache<Integer, Integer> lfuCache = new LFUCache<>(3);

        while(true) {
            System.out.println("Please choose the operation (get/put): ");
            String operation = scanner.next();
            if (operation.equalsIgnoreCase("get")) {
                System.out.println("Please Enter Key: ");
                Integer key = scanner.nextInt();
                if (lfuCache.get(key) == null) {
                    System.out.println("Key doesn't exist");
                } else {
                    System.out.println("Value: " + lfuCache.get(key));
                }
            } else {
                System.out.println("Please Enter Key: ");
                Integer key = scanner.nextInt();
                System.out.println("Please Enter Value: ");
                Integer value = scanner.nextInt();
                lfuCache.put(key, value);
            }
        }
    }
}
