package linkList;

import BaseConstruction.ListNode;

/**
 * Created by ludao on 2017/6/22.
 */
public class RemoveDuplicatesfromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode preHead = head;
        while (preHead.next!=null){
            if(preHead.val==preHead.next.val){
                preHead.next=preHead.next.next;
            }else{
                preHead = preHead.next;
            }
        }
        return head;
    }
}
