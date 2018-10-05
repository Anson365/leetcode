package linkList;

import BaseConstruction.ListNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/5/18.
 */
public class Partition_List_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        ListNode middle = new ListNode(0);
        ListNode startPoint = start;
        ListNode middlePoint = middle;
        startPoint.next = head;
        while (startPoint.next != null) {
            int temp = startPoint.next.val;
            if (temp < x) {
                startPoint = startPoint.next;
            } else {
                middlePoint.next = startPoint.next;
                startPoint.next = startPoint.next.next;
                middlePoint = middlePoint.next;
            }
        }
        middlePoint.next = null;
        startPoint.next = middle.next;
        return start.next;
    }
}
