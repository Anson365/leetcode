package array;

import BaseConstruction.Interval;

import java.util.*;

/**
 * Created by ludao on 2017/5/25.
 */
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null||intervals.size()==0){
            if(newInterval != null) {
                intervals = new ArrayList<Interval>();
                intervals.add(newInterval);
            }
            return intervals;
        }
        if(newInterval == null){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int tempStart = newInterval.start;
        int tempEnd = newInterval.end;
        Iterator<Interval> iterator = intervals.iterator();
        while (iterator.hasNext()){
            Interval interval = iterator.next();
            int start = interval.start;
            int end = interval.end;
            if(end<tempStart||start>tempEnd){
                continue;
            }
            if(start<tempStart){
                tempStart = start;
            }
            if(end>tempEnd){
                tempEnd = end;
            }
            iterator.remove();
        }
        Interval tempInterval = new Interval(tempStart,tempEnd);
        intervals.add(tempInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        return intervals;
    }


//    public static void main(String[] args){
//        Interval interval1 = new Interval(1,3);
//        Interval interval2 = new Interval(6,9);
//        Interval temp = new Interval(2,5);
//        List<Interval> list = new ArrayList<Interval>();
//        list.add(interval1);
//        list.add(interval2);
//        InsertInterval_57 insertInterval_57 = new InsertInterval_57();
//        insertInterval_57.insert(list,temp);
//        System.out.print("a");
//    }
}
