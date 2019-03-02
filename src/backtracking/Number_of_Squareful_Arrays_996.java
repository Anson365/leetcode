package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-02-28
 */
public class Number_of_Squareful_Arrays_996 {

    private int res;

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        helper(A, new boolean[A.length], new ArrayList<>());
        return res;
    }


    private void helper(int[] nums, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            res++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (list.size() > 0 && !check(nums[i] + list.get(list.size() - 1))) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(nums, used, list);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    private boolean check(int num) {
        double temp = Math.sqrt(num);
        return temp - (int)temp == 0;
    }
}
