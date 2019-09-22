package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson on 12/16/18.
 */
public class LRUCache146 {

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private final Integer CAPACITY;

    public LRUCache146(int capacity) {
        CAPACITY = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        node.next = head.next;
        node.next.pre = node;

        head.next = node;
        node.pre = head;

        return node.val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            Node tempNode = map.get(key);
            tempNode.val = value;
            map.put(key, tempNode);
            get(key);
            return;
        }
        map.put(key, node);
        if (map.size() > CAPACITY) {
            map.remove(tail.pre.key);
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;

        }
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    class Node {

        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache146 lruCache146 = new LRUCache146(2);
        lruCache146.put(1, 1);
        lruCache146.put(2, 2);
        lruCache146.get(1);
        lruCache146.put(3, 3);
        lruCache146.get(2);
        lruCache146.put(4, 4);
        lruCache146.get(1);       // returns -1 (not found)
        lruCache146.get(3);       // returns 3
        lruCache146.get(4);       // returns 4


    }
}
