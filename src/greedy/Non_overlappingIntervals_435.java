package greedy;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ludao on 2017/4/1.
 */
public class Non_overlappingIntervals_435 {


    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals==null||intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int terminal = intervals[0].end,count = 0,length = intervals.length;
        for(int i=1;i<length;i++){
            int tempStart = intervals[i].start;
            if(tempStart<terminal){
                int tempTerminal = intervals[i].end;
                terminal = terminal<tempTerminal?terminal:tempTerminal;
                count++;
            }else {
                terminal = intervals[i].end;
            }
        }
        return count;
    }
    static class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args){
        Interval interval1 = new Interval(10,100);
        Interval interval2 = new Interval(11,22);
        Interval interval3 = new Interval(9,33);
        Interval[] intervals = {interval1,interval2,interval3};
        int result = new Non_overlappingIntervals_435().eraseOverlapIntervals(intervals);
        return;


    }
}
