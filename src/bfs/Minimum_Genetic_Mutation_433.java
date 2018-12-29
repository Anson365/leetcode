package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Anson on 12/28/18.
 */
public class Minimum_Genetic_Mutation_433 {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        char[] chars = {'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<>();
        int step = 0;
        queue.offer(start);

        for (String b : bank) {
            bankSet.add(b);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curStr = queue.poll();
                if (curStr.equals(end)) {
                    return step;
                }
                for (int i = 0; i < curStr.length(); i++) {
                    for (char ch : chars) {
                        char[] curCharArray = curStr.toCharArray();
                        curCharArray[i] = ch;
                        String modStr = new String(curCharArray);
                        if (bankSet.contains(modStr)) {
                            queue.add(modStr);
                            bankSet.remove(modStr);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
