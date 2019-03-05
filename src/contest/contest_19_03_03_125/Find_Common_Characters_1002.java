package contest.contest_19_03_03_125;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-03-03
 */
public class Find_Common_Characters_1002 {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        String first = A[0];
        for (char temp : first.toCharArray()) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            map = helper(map, A[i]);
        }
        List<String> result = new ArrayList<>();
        map.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                result.add(String.valueOf(k));
            }
        });
        return result;
    }

    private Map<Character, Integer> helper(Map<Character, Integer> map, String str) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char temp : str.toCharArray()) {
            if (map.containsKey(temp)) {
                int freq = tempMap.getOrDefault(temp, 0);
                int val = map.get(temp);
                if (freq < val) {
                    tempMap.put(temp, freq + 1);
                }
            }
        }
        return tempMap;
    }
}
