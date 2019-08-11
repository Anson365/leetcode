package contest.contest_bi_6;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-08-10
 */
class Contest1 {

    public boolean isMajorityElement(int[] nums, int target) {
        int tempIndex = Arrays.binarySearch(nums, target);
        if (tempIndex < 0) {
            return false;
        }
        int start = tempIndex, end = tempIndex;
        while (start >= 0 && nums[start] == target) {
            start--;
        }
        while (end < nums.length && nums[end] == target) {
            end++;
        }
        int temp = end - start - 2;
        return temp >= nums.length / 2;
    }
}
