package contest.contest_162;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anson
 * Created on 2019-11-10
 */
class Contest3 {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> row = new HashSet<>();
                    Set<Integer> column = new HashSet<>();
                    dfs(grid, visited, row, column, i, j, dirs);
                    if (row.contains(0) || row.contains(m - 1) || column.contains(0)
                            || column.contains(n - 1)
                            || row.isEmpty() || column.isEmpty()) {
                        continue;
                    }
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] A, boolean[][] visited, Set<Integer> row, Set<Integer> column, int i, int j,
            int[][] dirs) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] == 1) {
            return;
        }
        visited[i][j] = true;
        row.add(i);
        column.add(j);
        for (int[] dir : dirs) {
            dfs(A, visited, row, column, i + dir[0], j + dir[1], dirs);
        }
    }
}
