package dfs;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-02-24
 */
public class Partition_to_K_Equal_Sum_Subsets_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int[] sums = new int[k];
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, sums, 0, sum / k, visited);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target, boolean[] visited) {
        if (index == nums.length) {
            return Arrays.stream(sums).allMatch(item -> item == target);
        }
        for (int i = 0; i < sums.length; i++) {
            if (visited[index] || sums[i] + nums[index] > target) {
                continue;
            }
            sums[i] += nums[index];
            visited[index] = true;
            boolean tempResult = dfs(nums, sums, index + 1, target, visited);
            if (tempResult) {
                return true;
            }
            sums[i] -= nums[index];
            visited[index] = false;
        }
        return false;
    }
}
