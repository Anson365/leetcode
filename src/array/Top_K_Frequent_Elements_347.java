package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/30/18.
 */
public class Top_K_Frequent_Elements_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length + 1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (list[freq] == null) {
                list[freq] = new ArrayList<Integer>();
            }
            list[freq].add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0 && result.size() <= k; i--) {
            if (list[i] != null) {
                result.addAll(list[i]);
            }
        }
        return result.subList(0, k);
    }
}
