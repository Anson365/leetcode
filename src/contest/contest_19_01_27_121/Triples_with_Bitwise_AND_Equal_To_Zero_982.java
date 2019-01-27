package contest.contest_19_01_27_121;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-01-27
 */
public class Triples_with_Bitwise_AND_Equal_To_Zero_982 {
    public int countTriplets(int[] A) {
        int count = 0;
        for (int i = 0 ; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int tmp = A[i] & A[j];
                for (int k = j; k < A.length; k++) {
                    int re = tmp & A[k];
                    if (re == 0) {
                        if (i == j && j == k) {
                            count += 1;
                        } else if (i == j || i == k || j == k) {
                            count += 3;
                        } else {
                            count += 6;
                        }
                    }
                }
            }
        }
        return count;
    }
}
