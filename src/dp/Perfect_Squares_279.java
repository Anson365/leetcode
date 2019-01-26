package dp;

/**
 * @author luodaihua
 * Created on 2019-01-26
 */
public class Perfect_Squares_279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = 1, min = Integer.MAX_VALUE;
            while (i - temp * temp  >= 0) {
                min = Math.min(min, dp[i - temp] + 1);
                temp++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
