package linkList;

import BaseConstruction.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/17/18.
 */
public class Reorder_List_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tempHead = slow.next;
        slow.next = null;
        // do the reverse
        ListNode current = null;

        while (tempHead != null) {
            ListNode temp = tempHead.next;
            tempHead.next = current;
            current = tempHead;
            tempHead = temp;
        }

        while (head != null && current != null) {
            ListNode tempPre = head.next;
            ListNode tempSuf = current.next;
            head.next = current;
            current.next = tempPre;
            head = tempPre;
            current = tempSuf;
        }

    }
}
