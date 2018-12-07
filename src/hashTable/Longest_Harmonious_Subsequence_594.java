package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/7/18.
 */
public class Longest_Harmonious_Subsequence_594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            int max = map.getOrDefault(num + 1, 0);
            int min = map.getOrDefault(num - 1, 0);
            if (max != 0 || min != 0) {
                result = Math.max(result, Math.max(max, min) + map.getOrDefault(num, 0) + 1);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}

