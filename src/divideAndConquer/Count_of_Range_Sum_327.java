package divideAndConquer;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author luodaihua
 * Created on 2019-02-14
 */
public class Count_of_Range_Sum_327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        treeMap.put(0L, 1);
        long sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Map<Long, Integer> tempMap = treeMap.subMap(sum - upper, true, sum - lower, true);
            for (int count : tempMap.values()) {
                res += count;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
