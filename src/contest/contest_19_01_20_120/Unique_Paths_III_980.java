package contest.contest_19_01_20_120;

/**
 * Created by Anson on 2019/1/20.
 */
public class Unique_Paths_III_980 {
    private int leftMark;
    private int count = 0;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        leftMark = grid.length * grid[0].length;
        helper(grid);
        return count;
    }

    private void helper(int[][] grid) {
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int[] start = new int[2], end = new int[2];
        findStartAndEndAndObstacles(grid, start, end);
        dfs(grid, marked, start[0], start[1], leftMark, true);
    }

    private void dfs(int[][] grid, boolean[][] marked, int currentI, int currentJ, int left, boolean start) {
        if (currentI < 0 || currentI >= grid.length || currentJ < 0 || currentJ >= grid[0].length) {
            return;
        }
        if (marked[currentI][currentJ]) {
            return;
        }
        if (grid[currentI][currentJ] == -1 || (!start && grid[currentI][currentJ] == 1)) {
            return;
        }
        if (grid[currentI][currentJ] == 2) {
            if (left != 1) {
                return;
            }
            count++;
            return;
        }
        int newLeft = left - 1;
        marked[currentI][currentJ] = true;
        for (int[] direction : directions) {
            dfs(grid, marked, currentI + direction[0], currentJ + direction[1], newLeft, false);
        }
        marked[currentI][currentJ] = false;
    }

    private void findStartAndEndAndObstacles(int[][] grid, int[] start, int[] end) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == -1) {
                    leftMark--;
                }
            }

        }
    }
}
