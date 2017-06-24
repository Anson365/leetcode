package linkList;

import BaseConstruction.ListNode;

/**
 * Created by ludao on 2017/6/24.
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                ListNode tempSlow = head;
                while (slow!=tempSlow){
                    tempSlow = tempSlow.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
