package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/27/18.
 */
public class Course_Schedule_III_630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b-a);
        int cost = 0;
        for (int[] temp:courses) {
            cost += temp[0];
            queue.add(temp[0]);
            if (cost > temp[1]) {
                cost -= queue.poll();
            }
        }
        return queue.size();
    }
}
