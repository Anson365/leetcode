package linkList;

import BaseConstruction.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/30/18.
 */
public class Remove_Nth_Node_From_End_of_List_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = head.next;
        ListNode temp = null;
        int count = 1;
        while(pointer != null) {
            if (count == n) {
                temp = head;
            } else if (count > n) {
                temp = temp.next;
            }
            pointer = pointer.next;
            count++;
        }
        if (count - 1 == n) {
            return head.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
