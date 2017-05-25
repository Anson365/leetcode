package dp;

/**
 * Created by ludao on 2017/4/29.
 */
public class PartitionEqualSubsetSum_416 {
       public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0){
            return true;
        }
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2!=0){
            return false;
        }
        int half = sum/2;
        boolean[] dp = new boolean[half+1];
        dp[0] = true;
        for(int i=0;i<nums.length;i++){
            for(int j=half;j>=nums[i];j--){

                dp[j] = dp[j]||dp[half-nums[i]];
            }
        }
        return dp[half];
    }
}
