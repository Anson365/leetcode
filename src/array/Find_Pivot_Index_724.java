package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/14/18.
 */
public class Find_Pivot_Index_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int temp : nums) {
            sum += temp;
        }

        for (int i = 0; i < nums.length; i++) {
            if (left == sum - left - nums[i]) {
                return i;
            } else {
                left += nums[i];
            }
        }
        return -1;
    }
}
