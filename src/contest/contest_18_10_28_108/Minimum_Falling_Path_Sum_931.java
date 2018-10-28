package contest.contest_18_10_28_108;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/28/18.
 */
public class Minimum_Falling_Path_Sum_931 {
    public int minFallingPathSum_dfs_force_LTE(int[][] A) {
        int column = A.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < column; i++) {
            int temp = dfs(0, i, A);
            min = Math.min(min, temp);
        }
        return min;
    }

    private int dfs (int row, int column, int[][] A) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int below = Integer.MAX_VALUE;

        if (row  == A.length - 1) {
            if (column >= 0) {
                left = A[row][column];
            }
            if (column < A.length) {
                right = A[row][column];
            }
            below = A[row][column];
            return Math.min(left, Math.min(below, right));
        } else {
            if (column - 1 >= 0) {
                left = dfs(row + 1, column - 1, A);
            }

            below = dfs(row + 1, column, A);
            if (column + 1 < A.length) {
                right = dfs(row + 1, column + 1, A);
            }
            return A[row][column] + Math.min(left, Math.min(below, right));
        }
    }

    public int minFallingPathSum(int[][] A) {
        int length = A.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int minThreeAbove = A[i - 1][j];
                minThreeAbove = j > 0 ? Math.min(minThreeAbove, A[i - 1][j - 1]) : minThreeAbove;
                minThreeAbove = (j < length - 1) ? Math.min(minThreeAbove, A[i - 1][j + 1]) : minThreeAbove;
                A[i][j] = A[i][j] + minThreeAbove;
            }
        }
        return Arrays.stream(A[length - 1]).min().getAsInt();
    }


    public static void main(String[] args) {
        Minimum_Falling_Path_Sum_931 minimumFallingPathSum931 = new Minimum_Falling_Path_Sum_931();
        minimumFallingPathSum931.minFallingPathSum_dfs_force_LTE(new int[][]{{-51,-35,74},{-62,14,-53},{94,61,-10}});
    }


}
