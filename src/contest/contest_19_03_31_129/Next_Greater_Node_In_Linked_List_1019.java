package contest.contest_19_03_31_129;

import java.util.ArrayList;
import java.util.List;

import BaseConstruction.ListNode;

/**
 * @author luodaihua
 * Created on 2019-03-31
 */
public class Next_Greater_Node_In_Linked_List_1019 {
    List<Integer> list = new ArrayList<>();

    public int[] nextLargerNodes(ListNode head) {
        helper(head);
        return list.stream().mapToInt(t -> (int)t).toArray();
    }


    private void helper(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val > slow.val) {
                list.add(fast.val);
                slow = slow.next;
                fast = slow.next;
            } else {
                fast = fast.next;
            }
        }
        if (slow != null) {
            list.add(0);
            helper(slow.next);
        }
    }
}
