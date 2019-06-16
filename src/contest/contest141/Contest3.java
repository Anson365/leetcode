package contest.contest141;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-06-16
 */
public class Contest3 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dp = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
        }
        dp[0][0] = 1;
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, -1}, {0, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, 0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                for (int[] direction : directions) {
                    int tempI = direction[0] + i;
                    int tempJ = direction[1] + j;
                    if (tempI < 0 || tempI >= grid.length || tempJ < 0 || tempJ >= grid.length) {
                        continue;
                    }
                    if (grid[tempI][tempJ] == 1) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[tempI][tempJ] + 1);
                }
            }
        }
        return dp[grid.length - 1][grid.length - 1] == Integer.MAX_VALUE ? -1 : dp[grid.length - 1][grid.length - 1];
    }
}
