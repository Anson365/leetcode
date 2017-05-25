package dp;

/**
 * Created by ludao on 2017/5/8.
 */
public class HouseRobber_198 {

    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                dp[i] = nums[i];
            }else if(i==1){
                dp[i] = Math.max(nums[0],nums[1]);
            }else {
                dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
            }
        }
        return nums[nums.length-1];
    }

}
