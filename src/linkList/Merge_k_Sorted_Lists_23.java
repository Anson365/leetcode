package linkList;

import BaseConstruction.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/16/18.
 */
public class Merge_k_Sorted_Lists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode(Integer.MIN_VALUE);
        ListNode pointer = listNode;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            pointer.next = temp;
            pointer = pointer.next;
            if (temp.next != null) {
                temp = temp.next;
                queue.add(temp);
            }
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode2;
        listNode1.next = listNode3;
        Merge_k_Sorted_Lists_23 merge_k_sorted_lists_23 = new Merge_k_Sorted_Lists_23();
        merge_k_sorted_lists_23.mergeKLists(new ListNode[]{listNode, listNode1});
    }
}
