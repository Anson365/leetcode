package dfs;

/**
 * Created by Anson on 12/27/18.
 */
public class Regions_Cut_By_Slashes_959 {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        int[][] memo = new int[length * 3][length * 3];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int x = i * 3, y = j * 3;
                if (grid[i].charAt(j) == '/') {
                    memo[x][y + 2] = memo[x + 1][y + 1] = memo[x + 2][y] = -1;
                } else {
                    memo[x][y] = memo[x + 1][y + 1] = memo[x + 2][y + 2] = -1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 3 * length; i++) {
            for (int j = 0; j < 3 * length; j++) {
                if (memo[i][j] == 0) {
                    count++;
                    dfs(i ,j ,memo);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] memo) {
        memo[i][j] = -1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < memo.length && y < memo.length && memo[x][y] == 0) {
                dfs(x, y, memo);
            }
        }
    }

}
