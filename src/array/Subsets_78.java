package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 8/20/18.
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void helper(int index, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        result.add(temp);
        for (int i = index; i < nums.length; i++) {
            List<Integer> tempList = new ArrayList<>(temp);
            tempList.add(nums[i]);
            helper(i + 1, nums, tempList, result);
        }
    }


    public static void main(String[] args) {
        Subsets_78 subsets_78 = new Subsets_78();
        int[] nums = {1,2};
        subsets_78.subsets(nums);
    }
}
