package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-03-03
 */
public class Top_K_Frequent_Elements_2_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] temp = new List[nums.length + 1];
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.forEach((key, val) -> {
            List<Integer> list = temp[val];
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(key);
            temp[val] = list;
        });
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            if (temp[i] != null) {
                result.addAll(temp[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Top_K_Frequent_Elements_2_347 top_k_frequent_elements_2_347 = new
                Top_K_Frequent_Elements_2_347();
        top_k_frequent_elements_2_347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
}
