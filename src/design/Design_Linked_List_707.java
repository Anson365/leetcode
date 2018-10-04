package design;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/4/18.
 * https://leetcode.com/problems/design-linked-list/description/
 */
public class Design_Linked_List_707 {
    /** Initialize your data structure here. */

    private Item head;
    private Item tail;
    private int size = 0;


    public Design_Linked_List_707() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Item item = getItem(index);
        if (item == null) {
            return -1;
        } else {
            return item.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Item newHead = new Item(val, head);
        this.head = newHead;
        if (size == 0) {
            tail = newHead;
        }
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Item newTail = new Item(val, null);
        if (size == 0) {
            head = newTail;
        } else {
            tail.next = newTail;
        }
        tail = newTail;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        if (size == 0) {
            Item item = new Item(val, null);
            head = item;
            tail = item;
            size++;
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
        } else if (index == size) {
            this.addAtTail(val);
        } else {
            Item item = this.getItem(index - 1);
            Item newItem = new Item(val, item.next);
            item.next = newItem;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
        } else {
            Item item = this.getItem(index - 1);
            Item next = item.next;
            if (next.next == null) {
                item.next = null;
                tail = item;
            } else {
                item.next = next.next;
            }
            size--;
        }
    }

    private Item getItem(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int count = 0;
        Item cur = head;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    class Item {
        private int val;
        private Item next;

        public Item(int val, Item next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Design_Linked_List_707 design_linked_list_707 = new Design_Linked_List_707();
        design_linked_list_707.addAtIndex(0, 1);
    }
}
