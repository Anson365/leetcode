package contest.contest_18_11_11_110;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/11/18.
 */
public class Minimum_Area_Rectangle_939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, TreeSet<Integer>> x = new HashMap<>();
        Map<Integer, TreeSet<Integer>> y = new HashMap<>();
        for (int[] point : points) {
            TreeSet<Integer> xList = x.getOrDefault(point[0], new TreeSet<>());
            TreeSet<Integer> yList = y.getOrDefault(point[1], new TreeSet<>());
            xList.add(point[1]);
            yList.add(point[0]);
            x.put(point[0], xList);
            y.put(point[1], yList);
        }
        int minArea = Integer.MAX_VALUE;
        for (int[] point : points) {
            int tempArea = helper(point, x, y);
            minArea = Math.min(tempArea, minArea);
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    private int helper(int[] point, Map<Integer, TreeSet<Integer>> x, Map<Integer, TreeSet<Integer>> y) {
        TreeSet<Integer> x_line = x.get(point[0]);
        int minArea = Integer.MAX_VALUE;
        for (int y_state : x_line) {
            if (y_state == point[1]) {
                continue;
            }
            int tempArea = calArea(y_state, point, y);
            if (tempArea == 0) {
                continue;
            } else {
                minArea = Math.min(minArea, tempArea);
            }
        }
        return minArea;
    }

    private int calArea(int y_state, int[] point, Map<Integer, TreeSet<Integer>> y) {
        if (y.containsKey(y_state) && y.containsKey(point[1])) {
            TreeSet<Integer> y_set_1 = new TreeSet<>(y.get(y_state));
            TreeSet<Integer> y_set_2 = y.get(point[1]);
            y_set_1.retainAll(y_set_2);
            if (y_set_1.size() < 2) {
                return 0;
            } else {
                int height = Math.abs(y_state - point[1]);
                Integer length_1 = y_set_1.lower(point[0]);
                Integer length_2 = y_set_1.higher(point[0]);
                int length = 0;
                if (length_1 == null && length_2 == null) {
                    return 0;
                }
                if (length_1 == null || (length_2 != null && Math.abs(length_1 - point[0]) > Math.abs(length_2 - point[0]))) {
                    length = Math.abs(length_2 - point[0]);
                } else {
                    length = Math.abs(length_1 - point[0]);
                }
                return height * length;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Minimum_Area_Rectangle_939 contest3 = new Minimum_Area_Rectangle_939();
        contest3.minAreaRect(new int[][] {{3,2},{3,1},{4,4},{1,1},{4,3},{0,3},{0,2},{4,0}});
    }
}
