package contest.contest_151;

import java.util.HashMap;
import java.util.Map;

import BaseConstruction.ListNode;

/**
 * @author luodaihua
 * Created on 2019-08-25
 */
class Contest3 {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int sum = 0;
        ListNode start = new ListNode(0);
        start.next = head;
        nodeMap.put(0, start);
        while (head != null) {
            ListNode current = head;
            sum += current.val;
            if (nodeMap.containsKey(sum)) {
                ListNode tempStart = nodeMap.get(sum);
                tempStart.next = current.next;
            } else {
                nodeMap.put(sum, current);
            }
            head = current.next;
        }
        return start.next;
    }
}
