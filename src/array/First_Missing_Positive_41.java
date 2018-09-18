package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/18/18.
 */
public class First_Missing_Positive_41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current > 0 && current < nums.length) {
                int temp = nums[current - 1];
                if (temp != current) {
                    nums[current - 1] = current;
                    nums[i] = temp;
                    i--;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
