package main.java.LLD.LFUCache;

import java.util.HashMap;

public class LFUCache<K, V> {
    int size, capacity, minFreq;
    HashMap<K, Node<K, V>> nodeMap;
    HashMap<Integer, DLL<K, V>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node<K, V> node) {
        int freq = node.frequency;
        DLL<K, V> currList = freqMap.get(freq);
        currList.removeNode(node);

        if(freq == minFreq && currList.size == 0) {
            minFreq++;
        }

        node.frequency++;
        freqMap.computeIfAbsent(node.frequency, f -> new DLL<K, V>()).addToHead(node);
    }

    public V get(K key) {
        if(!nodeMap.containsKey(key)) return null;
        Node<K, V> node = nodeMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(K key, V val) {
        if(capacity == 0) return;

        if(nodeMap.containsKey(key)) {
            Node<K, V> node = nodeMap.get(key);
            node.val = val;
            updateFreq(node);
        } else {
            if(size == capacity) {
                DLL<K, V> minList = freqMap.get(minFreq);
                Node<K, V> nodeToRemove = minList.removeTail();
                nodeMap.remove(nodeToRemove.key);
                size--;
            }
            Node<K, V> node = new Node<>(key, val);
            nodeMap.put(key, node);

            freqMap.computeIfAbsent(1, f -> new DLL()).addToHead(node);
            minFreq = 1;
            size++;
        }
    }
}
