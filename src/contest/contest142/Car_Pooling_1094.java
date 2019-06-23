package contest.contest142;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author luodaihua
 * Created on 2019-06-23
 */
public class Car_Pooling_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> t1[1] - t2[1]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((t1, t2) -> t1[2] - t2[2]);
        for (int[] trip : trips) {
            priorityQueue.add(trip);
        }
        int current = 0;
        for (int[] trip : trips) {
            int count = trip[0];
            int start = trip[1];
            current += count;
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[2] <= start) {
                current -= priorityQueue.poll()[0];
            }
            if (capacity < current) {
                return false;
            }
        }
        return true;
    }
}
