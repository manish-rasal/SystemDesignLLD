package main.java.LLD.LRUCache;

import java.util.HashMap;

public class LRUCache<K, V> {
    private final int capacity;
    private final HashMap<K, Node<K, V>> cache;
    private Node<K, V> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key) {
        if(cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return null;
    }

    public synchronized void put(K key, V value) {
        if(cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
        Node<K, V> node = new Node<>(key, value);
        cache.put(key, node);
        addToHead(node);
        if(cache.size() > capacity) {
            Node<K, V> nodeToRemove = removeTail();
            cache.remove(nodeToRemove.key);
        }
    }

    private void addToHead(Node<K, V> node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node<K, V> removeTail() {
        Node<K, V> removedNode = tail.prev;
        removeNode(tail.prev);
        return removedNode;
    }
}
