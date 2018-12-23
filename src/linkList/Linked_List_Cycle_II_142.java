package linkList;

import BaseConstruction.ListNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/7/18.
 */
public class Linked_List_Cycle_II_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
        }

        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }
        return head;
    }

//    public static void main(String[] args) {
//        Linked_List_Cycle_II_142 linked_list_cycle_ii_142 = new Linked_List_Cycle_II_142();
//        ListNode listNode1 = new ListNode(3);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(0);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode5.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        linked_list_cycle_ii_142.detectCycle(listNode1);
//    }
}
