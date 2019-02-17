package contest.contest_19_02_17_123;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-02-17
 */
public class Minimum_Number_of_K_Consecutive_Bit_Flips_995 {
    private int minutes = 0;
    public int orangesRotting(int[][] grid) {
        List<int[]> cells = new ArrayList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                if (val == 1) {
                    freshCount++;
                } else if (val == 2) {
                    cells.add(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        if (cells.size() == 0) {
            return -1;
        }
        bfs(grid, freshCount, cells);
        return minutes;
    }

    private void bfs(int[][] grid, int leftCount, List<int[]> cells) {
        if (cells.size() == 0) {
            if (leftCount == 0) {
                minutes--;
            } else {
                minutes = -1;
            }
            return;
        }
        List<int[]> newCells = new ArrayList<>();
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] cell : cells) {
            int i = cell[0];
            int j = cell[1];
            for (int[] direction : directions) {
                int v = direction[0];
                int h = direction[1];
                if (i + v >= 0 && i + v < grid.length && j + h >= 0 && j + h < grid[0].length) {
                    if (grid[i + v][j + h] == 1) {
                        newCells.add(new int[] {i + v, j + h});
                        grid[i + v][j + h] = 2;
                        leftCount--;
                    }
                }
            }
        }
        minutes++;
        bfs(grid, leftCount, newCells);
    }
}
