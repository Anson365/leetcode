package dfs;

/**
 * Created by ludao on 2017/5/9.
 */
public class PredicTheWinner_486 {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length<3){
            return true;
        }
        return helper(nums,0,nums.length-1)>=0;
    }

    private int helper(int[] nums,int start,int end){
        if(start==end){
            return nums[start];
        }
        return Math.max(nums[start]-helper(nums,start+1,end),nums[end]-helper(nums,start,end-1));
    }


}
