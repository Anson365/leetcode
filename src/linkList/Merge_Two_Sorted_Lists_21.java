package linkList;

import BaseConstruction.ListNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/17/18.
 */
public class Merge_Two_Sorted_Lists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pointer.next = l2;
                return result.next;
            }
            if (l2 == null) {
                pointer.next = l1;
                return result.next;
            }

            if (l1.val < l2.val) {
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        }
        return result.next;
    }

//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(1);
//        ListNode l5 = new ListNode(3);
//        ListNode l6 = new ListNode(4);
//        l1.next = l2;
//        l2.next = l3;
//        l4.next = l5;
//        l5.next = l6;
//        Merge_Two_Sorted_Lists_21 merge_two_sorted_lists_21 = new Merge_Two_Sorted_Lists_21();
//        merge_two_sorted_lists_21.mergeTwoLists(l1, l4);
//    }
}
