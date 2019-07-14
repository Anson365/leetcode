package contest.contest_145;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author luodaihua
 * Created on 2019-07-14
 */
public class Relative_Sort_Array_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> q1 = new ArrayList<>();
        List<Integer> q2 = new ArrayList<>();
        for (int a : arr1) {
            if (map.containsKey(a)) {
                q1.add(a);
            } else {
                q2.add(a);
            }
        }
        q1 = q1.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        }).collect(Collectors.toList());
        q2 = q2.stream().sorted().collect(Collectors.toList());
        q1.addAll(q2);
        return q1.stream().mapToInt(i -> i).toArray();
    }
}
