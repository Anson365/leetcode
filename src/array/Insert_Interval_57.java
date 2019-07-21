package array;

import BaseConstruction.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/2/18.
 */
public class Insert_Interval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        int tempSize = intervals.size();
        int newIntervalStart = newInterval.start;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= newIntervalStart) {
                intervals.add(i, newInterval);
                break;
            }
        }
        if (intervals.size() == tempSize) {
            intervals.add(newInterval);
        }
        Interval cur = new Interval(Integer.MAX_VALUE, Integer.MIN_VALUE);
        for (Interval interval : intervals) {
            if (cur == null || interval.start > cur.end) {
                result.add(interval);
                cur = interval;
            } else {
                cur.end = Math.max(cur.end, interval.end);
            }
        }
        return result;
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> result = new ArrayList<>();
        boolean added = false;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (end < newInterval[0]) {
                result.add(interval);
                continue;
            }
            if (start > newInterval[1]) {
                if (!added) {
                    result.add(newInterval);
                    added = true;
                }
                result.add(interval);
                continue;
            }
            newInterval[0] = Math.min(start, newInterval[0]);
            newInterval[1] = Math.max(end, newInterval[1]);
        }
        if (!added) {
            result.add(newInterval);
        }
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

//    public static void main(String[] args) {
//        Insert_Interval_57 insert_interval_57 = new Insert_Interval_57();
//        Interval interval = new Interval(1, 5);
//        Interval interval1 = new Interval(2, 7);
//        List<Interval> list = new ArrayList<>();
//        list.add(interval);
//        insert_interval_57.insert(list, interval1);
//    }
}
