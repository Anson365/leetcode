package segmenttree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/3/18.
 * https://leetcode.com/problems/my-calendar-iii/description/
 */
public class My_Calendar_III_732 {
    Map<Integer, Integer> map;
    public My_Calendar_III_732() {
       map = new HashMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int result = 0, ongoing = 0;
        for (Integer value : map.values()) {
            result = Math.max(result, ongoing += value);
        }
        return result;
    }


    public static void main(String[] args) {
        My_Calendar_III_732 my_calendar_iii_732 = new My_Calendar_III_732();
        my_calendar_iii_732.book(10, 20);
        my_calendar_iii_732.book(50, 60);
        my_calendar_iii_732.book(10, 40);
        my_calendar_iii_732.book(5, 15);
        my_calendar_iii_732.book(5, 10);
        my_calendar_iii_732.book(25, 55);
    }
}
