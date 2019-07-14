package contest.contest_bi_4;

/**
 * @author luodaihua
 * Created on 2019-07-13
 */
public class Divide_Array_Into_Increasing_Sequences_1121 {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        if (nums.length < 2 * K) {
            return false;
        }
        int n = nums.length / K;
        int max = 0;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                temp ++;
            } else {
                max = Math.max(temp, max);
                temp = 1;
            }
        }
        return max <= n;
    }
}
