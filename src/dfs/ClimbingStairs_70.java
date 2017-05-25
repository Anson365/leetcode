package dfs;

/**
 * Created by ludao on 2017/4/24.
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if(n==0||n==1||n==2){
            return n;
        }
        int[] nums = new int[n];
        nums[0]=0;
        nums[1]=1;
        nums[2]=2;
        for(int i=3;i<=n;i++){
            nums[n] = nums[n-1]+nums[n-2];
        }
        return nums[n];
    }


}
