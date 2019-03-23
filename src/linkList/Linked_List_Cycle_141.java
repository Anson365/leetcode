package linkList;

import BaseConstruction.ListNode;

/**
 * @author luodaihua
 * Created on 2019-03-23
 */
public class Linked_List_Cycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode current = head.next;
        while (current != null) {
            if (current.next == head) {
                return true;
            }
            ListNode temp = current.next;
            current.next = head;
            head = current;
            current = temp;
        }
        return false;
    }
}
