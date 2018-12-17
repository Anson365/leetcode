package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson on 12/16/18.
 */
public class LRUCache146 {
    private Node head;
    private Node tail;
    private int size = 0;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity * 4 / 3 + 1);
    }

    public int get(int key) {
        Node result = map.get(key);
        if (result == null) {
            return -1;
        }
        removeNode(result);
        putTail(result);
        return result.val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            if (size == capacity) {
                Node removed = head;
                head = head.next;
                map.remove(removed.key);
                size--;
            }
            putTail(node);
        }
        map.put(key, node);
        size++;
    }

    public void putTail(Node node) {
        if (head == null) {
            head = node;
        }
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }


    public void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        node.pre = null;
        node.next = null;
        if (pre != null && next != null) {
            pre.next = next;
            next.pre = pre;
        }else if (pre == null && next == null) {
            head = null;
            tail = null;
        } else if (pre != null) {
            pre.next = null;
            tail = pre;
        } else {
            next.pre = null;
            head = next;
        }
    }

    class Node {
        public int key;
        public int val;
        public Node next;
        public Node pre;

        public Node(int key,int val) {
            this.val = val;
            this.key = key;
        }
    }


    public static void main(String[] args) {
        LRUCache146 lruCache146 = new LRUCache146(2);
        lruCache146.put(1,1);
        lruCache146.put(2,2);
        lruCache146.get(1);
        lruCache146.put(3,3);
        lruCache146.get(2);
    }
}
