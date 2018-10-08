package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/8/18.
 */
public class Missing_Number_268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (i - nums[i]);
        }

        return sum + nums.length;
    }
}
