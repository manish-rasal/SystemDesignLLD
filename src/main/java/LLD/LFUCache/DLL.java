package main.java.LLD.LFUCache;

public class DLL<K, V> {
    Node<K, V> head, tail;
    int size;
    public DLL() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addToHead(Node<K, V> node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }

    public void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node<K, V> removeTail() {
        if(size == 0) return null;
        Node<K, V> nodeToRemove = tail.prev;
        removeNode(nodeToRemove);
        return nodeToRemove;
    }
}
