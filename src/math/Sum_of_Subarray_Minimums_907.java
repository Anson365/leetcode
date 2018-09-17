package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/16/18.
 */
public class Sum_of_Subarray_Minimums_907 {
    public int sumSubarrayMins(int[] A) {
        int[][] dp = new int[A.length + 1][A.length + 1];
        for (int i = 0; i < A.length; i++) {
            dp[1][i] = A[i];
        }
        for (int i = 2; i <= A.length; i++) {
            for (int j = 0; j <= A.length - i ; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], A[j + i - 1]);
            }
        }
        long sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp.length; j++) {
                sum += dp[i][j];
                sum = sum%(1000000000 + 7);
            }
        }
        return (int)sum;
    }
}
