package array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ludao on 2017/6/7.
 */
public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        doReverse(nums, 0, nums.length - 1);
        doReverse(nums, 0, k - 1);
        doReverse(nums, k, nums.length - 1);
    }

    public void doReverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

//    public static void main(String[] args){
//        int[] nums = {1};
//        int k = 0;
//        RotateArray_189 rotateArray_189 = new RotateArray_189();
//        rotateArray_189.rotate(nums,k);
//    }
}
