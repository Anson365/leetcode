package hashTable;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/6/18.
 */
public class Intersection_of_Two_Arrays_II_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer tempCount = map.getOrDefault(num, 0);
            map.put(num, tempCount++);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                resultList.add(num);
                int tempCount = map.get(num) - 1;
                if (tempCount <= 0) {
                    map.remove(num);
                }
            }
        }

        return resultList.stream().mapToInt(item -> (int)item).toArray();
    }
}
