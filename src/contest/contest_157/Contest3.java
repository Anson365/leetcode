package contest.contest_157;

/**
 * @author luodaihua
 * Created on 2019-10-06
 */
public class Contest3 {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int temp = helper(grid, i, j, new boolean[grid.length][grid[0].length], 0);
                max = Math.max(max, temp);
            }
        }
        return max;
    }


    private int helper(int[][] grid, int i, int j, boolean[][] memo, int pre) {
        if (i < 0 || i >= grid.length) {
            return pre;
        }
        if (j < 0 || j >= grid[0].length) {
            return pre;
        }
        if (grid[i][j] == 0) {
            return pre;
        }
        if (memo[i][j]) {
            return pre;
        }
        memo[i][j] = true;
        int left = helper(grid, i, j - 1, memo, pre + grid[i][j]);
        int right = helper(grid, i, j + 1, memo, pre + grid[i][j]);
        int up = helper(grid, i - 1, j, memo, pre + grid[i][j]);
        int down = helper(grid, i + 1, j, memo, pre + grid[i][j]);
        memo[i][j] = false;
        return Math.max(left, Math.max(right, Math.max(up, down)));
    }
}
