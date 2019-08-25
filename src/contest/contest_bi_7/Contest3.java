package contest.contest_bi_7;

import java.util.PriorityQueue;

/**
 * @author luodaihua
 * Created on 2019-08-24
 */
class Contest3 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.add(stick);
        }
        while (queue.size() > 1) {
            int tmp1 = queue.poll();
            int tmp2 = queue.poll();
            queue.add(tmp1 + tmp2);
        }
        return queue.poll();

    }
}
