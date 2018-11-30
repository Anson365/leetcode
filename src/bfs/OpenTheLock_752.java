package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/29/18.
 */
public class OpenTheLock_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String dead : deadends) {
            deadSet.add(dead);
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> didSet = new HashSet<>();
        int result = 0;
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (target.equals(current)) {
                    return result;
                }
                if (deadSet.contains(current) || didSet.contains(current)) {
                    continue;
                }
                for (int j = 0; j < current.length(); j++) {
                    char[] tempForward = current.toCharArray();
                    char tempTargetForward = (char) ('0' + (tempForward[j] + 1 - '0') % 10);
                    tempForward[j] = tempTargetForward;
                    String tempForwardStr = new String(tempForward);
                    if (!deadSet.contains(tempForwardStr) && !didSet.contains(tempForwardStr)) {
                        queue.offer(tempForwardStr);
                    }


                    char[] tempBack = current.toCharArray();
                    char tempTargetBack = (char) ('0' + (tempBack[j] + 9 - '0') % 10);
                    tempBack[j] = tempTargetBack;
                    String tempBackStr = new String(tempBack);
                    if (!deadSet.contains(tempBackStr) && !didSet.contains(tempBackStr)) {
                        queue.offer(new String(tempBackStr));
                    }
                }
                didSet.add(current);
            }
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
        OpenTheLock_752 openTheLock_752 = new OpenTheLock_752();
        openTheLock_752.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
    }
}
