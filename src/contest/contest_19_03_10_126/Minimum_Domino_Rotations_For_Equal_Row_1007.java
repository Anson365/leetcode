package contest.contest_19_03_10_126;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-03-10
 */
public class Minimum_Domino_Rotations_For_Equal_Row_1007 {

    public int minDominoRotations(int[] A, int[] B) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int commonA = findCommon(A, B);
        int commonB = findCommon(B, A);
        if (commonA < 0) {
            return -1;
        }
        if (commonA == commonB) {
            return findCount(A, B, commonA);
        } else {
            return Math.min(findCount(A, B, commonA), findCount(A, B, commonB));
        }
    }

    private int findCommon(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int target = A.length;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            int freqA = map.getOrDefault(a, 0) + 1;
            map.put(a, freqA);
            int freqB = map.getOrDefault(b, 0) + 1;
            map.put(b, freqB);
        }
        int maxKey = 0, maxFreq = 0;
        for (Integer key : map.keySet()) {
            if (maxFreq < map.get(key)) {
                maxFreq = map.get(key);
                maxKey = key;
            }
        }
        if (maxFreq < target) {
            return -1;
        }
        return maxKey;
    }

    private int findCount(int[] a, int[] b, int common) {
        int minA = 0, minB = 0;
        for (int i = 0; i < a.length; i++) {
            int tempA = a[i];
            int tempB = b[i];
            if (tempA != common && tempB != common) {
                return -1;
            }
            if (tempA != common) {
                minA++;
            } else if (tempB != common) {
                minB++;
            }
        }
        return Math.min(minA, minB);
    }
}
