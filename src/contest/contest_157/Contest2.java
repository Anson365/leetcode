package contest.contest_157;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-10-06
 */
public class Contest2 {

    private int max = 1;
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = map.getOrDefault(arr[i] + difference, 0);
            max = Math.max(max, temp + 1);
            map.put(arr[i], Math.max(temp + 1, map.getOrDefault(arr[i], 1)));
        }
        return max;
    }
}
