package linkList;

import BaseConstruction.ListNode;

/**
 * Created by ludao on 2017/6/20.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode p1=l1, p2=l2;

        p1.next = head;
        while(p1.next!=null) {
            // keep moving larger node to list 2;

            if(p1.next.val>=x) {
                ListNode tmp = p1.next;
                p1.next = tmp.next;

                p2.next = tmp;
                p2 = p2.next;
            }
            else {
                p1 = p1.next;
            }
        }

        // conbine lists 1 and 2;
        p2.next = null;
        p1.next = l2.next;
        return l1.next;
    }
}
