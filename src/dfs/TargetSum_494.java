package dfs;

/**
 * Created by ludao on 2017/4/23.
 */
public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int sum = 0,index=0;
        return dfs(nums,0,S,0);
    }

    private int dfs(int[] nums,int sum,int S,int index){
        if(index==nums.length){
            if(sum==S){
                return 1;
            }else {
                return 0;
            }
        }
        int add = dfs(nums,sum+nums[index],S,index+1);
        int sub = dfs(nums,sum-nums[index],S,index+1);
        return add+sub;
    }


//    public static void main(String[] args){
//        int[] nums = {1,1,1,1,1};
//        int S = 3;
//        TargetSum_494 targetSum_494 = new TargetSum_494();
//        int count = targetSum_494.findTargetSumWays(nums,3);
//        return;
//    }
}
