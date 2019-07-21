package contest.contest_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-07-21
 */
public class Number_of_Equivalent_Domino_Pairs_5130 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] d : dominoes) {
            Map<Integer, Integer> tmpMap = map.getOrDefault(d[0] + d[1], new HashMap<>());
            int tempFreq = tmpMap.getOrDefault(d[0], 0);
            tmpMap.put(d[0], tempFreq + 1);
            map.put(d[0] + d[1], tmpMap);
        }
        int temp = 0;
        int temp1 = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
            int sum = entry.getKey();
            Map<Integer, Integer> tmpMap = entry.getValue();
            for (Map.Entry<Integer, Integer> tmp : tmpMap.entrySet()) {
                if (tmp.getKey() != sum - tmp.getKey()) {
                    temp += (tmp.getValue() * tmpMap.getOrDefault(sum - tmp.getKey(), 0));
                }
                if (tmp .getValue() - 1 > 0) {
                    temp1 += (tmp.getValue() - 1) * tmp.getValue();
                }
            }
        }
        return (temp + temp1) / 2;
    }
}
