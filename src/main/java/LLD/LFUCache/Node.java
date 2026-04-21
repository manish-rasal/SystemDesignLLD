package main.java.LLD.LFUCache;

public class Node <K, V> {
    K key;
    V val;
    int frequency;
    Node<K, V> prev, next;

    public Node (K key, V val) {
        this.key = key;
        this.val = val;
        frequency = 1;
    }
}
