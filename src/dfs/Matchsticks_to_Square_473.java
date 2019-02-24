package dfs;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-02-23
 */
public class Matchsticks_to_Square_473 {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) {
            return false;
        }
        return dfs(nums, new int[4], 0, sum/4);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) {
                continue;
            }
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) {
                return true;
            }
            sums[i] -= nums[index];
        }
        return false;
    }
}
