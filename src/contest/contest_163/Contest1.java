package contest.contest_163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anson
 * Created on 2019-11-17
 */
class Contest1 {
//    位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
//    位于 grid[i][m - 1] 的元素将会移动到 grid[i + 1][0]。
//    位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        if (k == 0) {
            return helper(grid);
        }
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 == m) {
                    tmp[i][0] = grid[i][j];
                } else {
                    tmp[i][j + 1] = grid[i][j];
                }
            }
        }
        int end = grid[n - 1][m - 1];
        for (int i = n - 1; i > 0; i--) {
            tmp[i][0] = tmp[i-1][0];
        }
        tmp[0][0] = end;
        return shiftGrid(tmp, k - 1);
    }


    private List<List<Integer>> helper(int[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                temp.add(grid[i][j]);
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        Contest1 contest1 = new Contest1();
        contest1.shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1);
    }
}
