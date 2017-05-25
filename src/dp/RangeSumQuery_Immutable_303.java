package dp;

/**
 * Created by ludao on 2017/5/8.
 */
public class RangeSumQuery_Immutable_303 {
    private int[] num;

    public RangeSumQuery_Immutable_303(int[] nums) {
        num = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                num[i] = nums[i];
            }else {
                num[i] = num[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i<=0){
            return num[j];
        }
        return num[j] - num[i-1];
    }
}
