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
    private int size;
    private final Integer CAPACITY;


    public LRUCache146(int capacity) {
        CAPACITY = capacity;
        map = new HashMap<>(capacity * 4 / 3 + 1);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (size > 1) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
        }
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
        if (size == CAPACITY) {
            map.remove(head.next.key);
            head.next = head.next.next;
            size--;
        }
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
        map.put(key, node);
        size++;
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

//    public static void main(String[] args) {
//        LRUCache146 lruCache146 = new LRUCache146(2);
//        lruCache146.put(2,6);
//        lruCache146.put(1,5);
//        lruCache146.put(1,2);
//        lruCache146.get(2);
//    }
}
