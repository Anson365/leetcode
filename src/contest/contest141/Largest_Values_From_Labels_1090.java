package contest.contest141;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author luodaihua
 * Created on 2019-06-16
 */
public class Largest_Values_From_Labels_1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p2[0] - p1[0]);
        for (int i = 0; i < values.length; i++) {
            queue.add(new int[] {values[i], labels[i]});
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        int setSize = 0;
        int sum = 0;
        while (!queue.isEmpty() && setSize < num_wanted) {
            int[] pair = queue.poll();
            int freq = freqMap.getOrDefault(pair[1], 0);
            if (freq + 1 <= use_limit) {
                sum += pair[0];
                setSize++;
                freqMap.put(pair[1], freq + 1);
            }
        }
        return sum;
    }

}
