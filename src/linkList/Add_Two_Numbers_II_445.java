package linkList;

import BaseConstruction.ListNode;

import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/30/18.
 */
public class Add_Two_Numbers_II_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        int carry = 0;
        ListNode head = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                carry += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                carry += stack2.pop();
            }
            int val = carry % 10;
            carry /= 10;
            ListNode tempNode = new ListNode(val);
            tempNode.next = head.next;
            head.next = tempNode;
        }
        if (carry != 0) {
            head.val = carry;
            return head;
        }
        return head.next;
    }
}
