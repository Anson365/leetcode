package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anson on 12/25/18.
 */
public class Product_of_Array_Except_Self_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

//    public static void main(String[] args) {
//        Product_of_Array_Except_Self_238 product_of_array_except_self_238 = new Product_of_Array_Except_Self_238();
//        product_of_array_except_self_238.productExceptSelf(new int[]{1,2,3,4});
//    }
}
