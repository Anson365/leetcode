package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author luodaihua
 * Created on 2019-02-21
 */
public class Majority_Element_II_229 {
    public List<Integer> majorityElement(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int threshold = A.length / 3;
        return map.keySet().stream().filter(key -> map.get(key) > threshold).collect(Collectors.toList());
    }
}
