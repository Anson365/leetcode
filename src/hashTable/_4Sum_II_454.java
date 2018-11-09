package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/9/18.
 */
public class _4Sum_II_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A) {
            for (int b : B) {
                int temp = a + b;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int temp = c + d;
                result += map.getOrDefault(-(c + d), 0);
            }
        }
        return result;
    }
}
