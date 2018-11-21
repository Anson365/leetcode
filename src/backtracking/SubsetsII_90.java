package backtracking;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/21/18.
 */
public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup_WithSet(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());
        if (nums.length < 1) {
            return new ArrayList<>(result);
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            current.add(nums[i]);
            temp.add(current);
            for (List<Integer> list : result) {
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(nums[i]);
                temp.add(tempList);
            }
            result.addAll(temp);
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, result, cur, nums);
        return result;
    }

    private void helper(int index, List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (index <= nums.length) {
            res.add(cur);
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            helper(index + 1, res, new ArrayList<>(cur), nums);
            cur.remove(cur.size() - 1);
        }
    }

}
