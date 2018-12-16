package toutiao;

import BaseConstruction.ListNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/15/18.
 */
public class RemoveUnion {

    public ListNode removeUnion(ListNode source, ListNode target) {
        ListNode pre = new ListNode(0);
        pre.next = source;
        ListNode head = pre;
        while (source != null && target != null) {
            int sourceValue = source.val;
            int targetValue = target.val;
            if (sourceValue == targetValue) { //一样 remove
                source = source.next;
                target = target.next;
            } else if (sourceValue > targetValue) { // 大的话 取target的下一个
                target = target.next;
            } else { // 小的话取下一个
                pre.next = source;
                source = source.next;
                pre = pre.next;
            }
        }
        if (source != null) { //取剩下的
            pre.next = source;
        }
        return head.next;
    }
}
