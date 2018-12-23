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

//    public static void main(String[] args) {
//        Insert_Interval_57 insert_interval_57 = new Insert_Interval_57();
//        Interval interval = new Interval(1, 5);
//        Interval interval1 = new Interval(2, 7);
//        List<Interval> list = new ArrayList<>();
//        list.add(interval);
//        insert_interval_57.insert(list, interval1);
//    }
}
