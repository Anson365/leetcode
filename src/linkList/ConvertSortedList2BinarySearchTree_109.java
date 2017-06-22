package linkList;

import BaseConstruction.ListNode;
import BaseConstruction.TreeNode;

/**
 * Created by ludao on 2017/6/21.
 */
public class ConvertSortedList2BinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return helper(head, null);
    }
    public TreeNode helper(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = helper(head, slow);
        thead.right = helper(slow.next, tail);
        return thead;
    }
}
