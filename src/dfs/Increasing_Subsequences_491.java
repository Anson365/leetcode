package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-03-10
 */
public class Increasing_Subsequences_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(result, list, 0, nums);
        return new ArrayList<>(result);
    }
    
    public void helper(Set<List<Integer>> result, List<Integer> list, int index, int[] nums) {
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (list.size() == index || list.get(list.size() - 1) <= num) {
                list.add(num);
                helper(result, list, i + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
