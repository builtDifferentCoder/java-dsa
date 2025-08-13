import java.util.HashMap;
import java.util.Map;

class LFUNode {
    int key;
    int data;
    LFUNode prev;
    LFUNode next;
    int frequency;

    public LFUNode(int key, int val) {
        this.key = key;
        this.data = val;
        this.prev = null;
        this.next = null;
        this.frequency = 1;
    }
}

class DoublyLinkedList {
    LFUNode head;
    LFUNode tail;
    int size;

    public DoublyLinkedList() {
        this.head = new LFUNode(0, 0);
        this.tail = new LFUNode(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    public void insertAtHead(LFUNode node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
        size++;
    }

    public void removeNode(LFUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public LFUNode removeAtTail() {
        if (size == 0) return null;
        LFUNode node = this.tail.prev;
        removeNode(node);
        return node;
    }
}

public class LFU {
    Map<Integer, LFUNode> keys;                  // key -> node
    Map<Integer, DoublyLinkedList> freq;         // frequency -> list of nodes
    int capacity;
    int minFreq;
    int size;

    public LFU(int capacity) {
        this.keys = new HashMap<>();
        this.freq = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
    }

    public int get(int key) {
        LFUNode node = keys.get(key);
        if (node == null) return -1;
        updateFreq(node);
        return node.data;
    }

    public void set(int key, int value) {
        if (capacity == 0) return;

        LFUNode existingNode = keys.get(key);
        if (existingNode != null) {
            existingNode.data = value;
            updateFreq(existingNode);
            return;
        }

        if (size == capacity) {
            DoublyLinkedList minFreqList = freq.get(minFreq);
            LFUNode nodeToRemove = minFreqList.removeAtTail();
            keys.remove(nodeToRemove.key);
            size--;
        }

        LFUNode newNode = new LFUNode(key, value);
        keys.put(key, newNode);
        freq.computeIfAbsent(1, k -> new DoublyLinkedList()).insertAtHead(newNode);
        minFreq = 1;
        size++;
    }

    private void updateFreq(LFUNode node) {
        int oldFreq = node.frequency;
        DoublyLinkedList oldList = freq.get(oldFreq);
        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        node.frequency++;
        freq.computeIfAbsent(node.frequency, k -> new DoublyLinkedList()).insertAtHead(node);
    }
}
