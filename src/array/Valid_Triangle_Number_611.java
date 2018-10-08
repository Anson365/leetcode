package array;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/8/18.
 */
public class Valid_Triangle_Number_611 {
    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums == null && nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                for (int m = j - 1; m >= 0; m--) {
                    if (nums[m] + nums[j] > nums[i]) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Valid_Triangle_Number_611 valid_triangle_number_611 = new Valid_Triangle_Number_611();
        valid_triangle_number_611.triangleNumber(new int[] {2,2,3,4});
    }
}
