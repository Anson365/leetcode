package design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author luodaihua
 * Created on 2019-06-26
 */
public class Find_Median_from_Data_Stream_256 {

    private PriorityQueue<Integer> min = new PriorityQueue();
    private PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : max.peek();
    }
}
