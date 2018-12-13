package linkList;

import BaseConstruction.ListNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/13/18.
 */
public class Palindrome_Linked_List_234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow;
        slow = slow.next;
        newHead.next = null;
        while(slow != null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = newHead;
            newHead = temp;
        }

        while (head != null || newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;

    }
}
