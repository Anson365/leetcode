package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/20/18.
 */
public class Maximum_Product_Subarray_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tempMin = 1, tempMax = 1, max = nums[0];
        for (int temp : nums) {
            int curMin = Math.min(Math.min(tempMin * temp, tempMax * temp), temp);
            int curMax = Math.max(Math.max(tempMin * temp, tempMax * temp), temp);
            tempMin = curMin;
            tempMax = curMax;
            max = Math.max(max, tempMax);
        }
        return max;
    }

//    public static void main(String[] args) {
//        Maximum_Product_Subarray_152 maximum_product_subarray_152 = new Maximum_Product_Subarray_152();
//        maximum_product_subarray_152.maxProduct(new int[]{2,3,-2,4});
//    }
}
