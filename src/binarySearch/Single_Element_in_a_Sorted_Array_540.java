package binarySearch;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/8/18.
 */
public class Single_Element_in_a_Sorted_Array_540 {
    public int singleNonDuplicate_ON(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int middle = (start + end) / 2;
            if (middle % 2 == 1) {
                middle -= 1;
            }
            if (nums[middle] != nums[middle + 1]) {
                end = middle;
            } else {
                start = middle + 2;
            }
        }
        return nums[start];
    }
}
