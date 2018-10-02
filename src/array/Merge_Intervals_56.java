package array;

import BaseConstruction.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/1/18.
 */
public class Merge_Intervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, (item1, item2) -> item1.start - item2.start);
        Interval first = intervals.get(0);
        int start = first.start, end = first.end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            int tempStart = interval.start;
            int tempEnd = interval.end;
            if (end >= tempStart) {
                start = Math.min(start, tempStart);
                end = Math.max(end, tempEnd);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
            if (i == intervals.size() - 1) {
                result.add(new Interval(start, end));
            }
        }
        return result;
    }
}
