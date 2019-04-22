package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-04-22
 */
public class Longest_Arithmetic_Sequence_1027 {
    public int longestArithSeqLength(int[] A) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                Map<Integer, Integer> tmpMap = map.computeIfAbsent(A[j] - A[i], t -> new HashMap<>
                        ());
                int length = tmpMap.getOrDefault(j, 1) + 1;
                tmpMap.put(j, length);
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
