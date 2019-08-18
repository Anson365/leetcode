package contest.contest_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-08-18
 */
class Contest3 {
    public int maxDistance(int[][] grid) {
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    tmp.add(new int[]{i, j});
                }
            }
        }
        if (tmp.size() == grid.length * grid[0].length || tmp.size() == 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                max = Math.max(max, distance(tmp, i, j));
            }
        }
        return max;
    }

    private int distance(List<int[]> lands, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int[] land : lands) {
            min = Math.min(Math.abs(i - land[0]) + Math.abs(j - land[1]), min);
        }
        return min;
    }
}
