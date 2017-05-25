package dp;

import java.util.Arrays;

/**
 * Created by ludao on 2017/5/10.
 */
public class CombinationSumIV_377 {
    public int combinationSum4(int[] nums, int target) {
        if(nums==null||nums.length==0||target<=0){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]){
                    dp[i] = dp[i] + 1;
                }else if(i-nums[j]>0){
                    dp[i] = dp[i-nums[j]]+dp[i];
                }
            }
        }
        return dp[target];
    }
}
