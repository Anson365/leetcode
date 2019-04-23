package dfs;

/**
 * @author luodaihua
 * Created on 2019-04-23
 */
public class Out_of_Boundary_Paths_576 {

    private static final int MOD = (int) 1e9 + 7;

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) {
            return 0;
        }
        Integer[][][] memo = new Integer[m][n][N + 1];
        dfs(m, n, N, i, j, memo);
        return memo[i][j][N];
    }

    private int dfs(int m, int n, int step, int i, int j, Integer[][][] memo) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (step == 0) {
            return 0;
        }
        if (memo[i][j][step] != null) {
            return memo[i][j][step];
        }
        long countUp = dfs(m, n, step - 1, i - 1, j, memo);
        long countDown = dfs(m, n, step - 1, i + 1, j, memo);
        long countLeft = dfs(m, n, step - 1, i, j - 1, memo) ;
        long countRight = dfs(m, n, step - 1, i, j + 1, memo) ;
        memo[i][j][step] = (int)((countUp + countDown + countLeft + countRight) % MOD);
        return memo[i][j][step];
    }

    public static void main(String[] args) {
        Out_of_Boundary_Paths_576 out_of_boundary_paths_576 = new Out_of_Boundary_Paths_576();
        out_of_boundary_paths_576.findPaths(10, 10, 0, 5, 5);
    }
}
