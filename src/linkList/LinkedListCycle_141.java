package linkList;

import BaseConstruction.ListNode;

/**
 * Created by ludao on 2017/6/19.
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode current = head;
        while (current!=null){
            if(current.next == head){
                return true;
            }
            ListNode temp = current.next;
            current.next = head;
            current = temp;
        }
        return false;
    }
}
