package toutiao;

import BaseConstruction.ListNode;

/**
 * Created by Anson on 12/22/18.
 */
public class ReversePartList {
    public static ListNode reverse(ListNode head, int k){
        if (head == null || k <= 1) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(fast != null && i < k - 1) {
            fast = fast.next;
            i++;
        }
        if (i < k - 1) {//间距不足k
            return head;
        }
        ListNode tempPoint = slow.next;
        while (tempPoint != fast) {
            ListNode temp = tempPoint;
            tempPoint = tempPoint.next;
            temp.next = slow;
            slow = temp;
        }
        fast = fast.next;
        tempPoint.next = slow;
        ListNode nextHead = reverse(fast, k);
        head.next = nextHead;
        return tempPoint;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);
        a.next.next.next.next.next.next = new ListNode(7);
        a.next.next.next.next.next.next.next = new ListNode(8);
        a.next.next.next.next.next.next.next.next = new ListNode(9);


        head.next = reverse(a,4);
        ListNode h = head.next;
        while(h!=null){
            System.out.print(" " + h.val);
            h = h.next;
        }
    }

}
