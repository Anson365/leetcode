package dp;

/**
 * Created by ludao on 2017/5/8.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i] + (dp[i-1]>0?dp[i-1]:0);
            max = Math.max(dp[i],max);
        }
        return max;
    }

//    public static void main(String[] args){
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        MaximumSubarray_53 maximumSubarray_53 = new MaximumSubarray_53();
//        int reuslt = maximumSubarray_53.maxSubArray(nums);
//        return;
//    }
}
