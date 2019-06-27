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

    public static void main(String[] args) {
        Find_Median_from_Data_Stream_256 find = new Find_Median_from_Data_Stream_256();
        find.addNum(6);
        find.addNum(10);
        find.addNum(2);
        find.addNum(6);
        find.addNum(5);
        find.addNum(0);
        find.addNum(6);
        find.addNum(3);
        find.addNum(1);
        find.addNum(0);
        find.addNum(0);
    }

}
