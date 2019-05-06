package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-04-26
 */
public class Permutations_II_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, list, result);
        return result;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, result);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
