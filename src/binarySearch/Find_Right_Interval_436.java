package binarySearch;

import BaseConstruction.Interval;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/14/18.
 */
public class Find_Right_Interval_436 {
    public int[] findRightInterval(Interval[] intervals) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[intervals.length];
        Map<Integer, Integer> startIndexMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i].start);
            startIndexMap.put(intervals[i].start, i);
        }
        Collections.sort(list);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i].end;
            int index = binarySearch(list, end);
            if (index < 0) {
                result[i] = -1;
            } else {
                result[i] = startIndexMap.get(list.get(index));
            }
        }
        return result;
    }

    private int binarySearch(List<Integer> startList, int target) {
        int low = 0, high = startList.size() - 1;
        while (low < high) {
            int middle = (low + high) / 2;
            if (startList.get(middle) < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        if (startList.get(high) < target) {
            return -1;
        } else {
            return high;
        }
    }

//    public static void main(String[] args) {
//        Find_Right_Interval_436 find_right_interval_436 = new Find_Right_Interval_436();
////        [[1,12],[2,9],[3,10],[13,14],[15,16],[16,17]]
//        Interval interval1 = new Interval(1,12);
//        Interval interval2 = new Interval(2,9);
//        Interval interval3 = new Interval(3,10);
//        Interval interval4 = new Interval(13,14);
//        Interval interval5 = new Interval(15,16);
//        Interval interval6 = new Interval(16, 17);
//        Interval[] array = {interval1, interval2, interval3, interval4, interval5, interval6};
//        int[] result = find_right_interval_436.findRightInterval(array);
//        System.out.println(result);
//    }
}
