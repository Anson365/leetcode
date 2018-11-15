package point_offer;

import BaseConstruction.ListNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/13/18.
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        int step = 0;
        ListNode first = head;
        ListNode second = head;
        while (step < k && first != null) {
            first = first.next;
            step++;
        }
        if (step < k) {
            return null;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        solution.FindKthToTail(listNode1, 6);
    }
}
