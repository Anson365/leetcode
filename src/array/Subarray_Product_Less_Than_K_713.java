package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/9/18.
 */
public class Subarray_Product_Less_Than_K_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int temp = 1, count = 0, left = 0, right = 0;
        for (;right < nums.length; right++) {
            temp *= nums[right];
            while (temp >= k && right >= left) {
                temp /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
