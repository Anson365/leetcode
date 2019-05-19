package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author luodaihua
 * Created on 2019-05-08
 */
public class Burst_Balloons_312 {

    public int maxCoins(int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        boolean[] memo = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        int result = 0;
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int index : list) {
                int left = 1, right = 1;
                int i = index - 1, j = index + 1;
                while (!memo[i] && i >= 0) {
                    i--;
                }
                while (!memo[i] && j < nums.length) {
                    j++;
                }
                left = i >= 0 ? nums[i] : left;
                right = j < nums.length ? nums[j] : right;
                result += left * right * key;
            }
        }
        return result;
    }
}
