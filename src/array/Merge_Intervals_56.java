package array;

import BaseConstruction.Interval;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (end >= tmp[0]) {
                end = Math.max (end, tmp[1]);
            } else {
                list.add(new int[]{start, end});
                start = tmp[0];
                end = tmp[1];
            }
        }
        list.add(new int[]{start, end});
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
