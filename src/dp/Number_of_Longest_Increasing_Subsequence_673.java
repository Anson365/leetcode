package dp;

/**
 * @author luodaihua
 * Created on 2019-05-20
 */
public class Number_of_Longest_Increasing_Subsequence_673 {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        int[] freq = new int[length];
        dp[0] = 1;
        freq[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            int currentMax = 1;
            freq[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (currentMax == dp[j] + 1) {
                        freq[i] += freq[j];
                    } else if (currentMax < dp[j] + 1) {
                        freq[i] = freq[j];
                        currentMax = dp[j] + 1;
                    }
                }
            }
            dp[i] = currentMax;
            max = Math.max(max, currentMax);
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                count += freq[i];
            }
        }
        return count;
    }

}
