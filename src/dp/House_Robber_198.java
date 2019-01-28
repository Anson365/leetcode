package dp;

/**
 * @author luodaihua
 * Created on 2019-01-28
 */
public class House_Robber_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0; dp[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }
}
