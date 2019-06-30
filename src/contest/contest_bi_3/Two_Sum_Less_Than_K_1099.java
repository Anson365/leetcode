package contest.contest_bi_3;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-06-29
 */
public class Two_Sum_Less_Than_K_1099 {

    public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2 || K == 1) {
            return -1;
        }
        Arrays.sort(A);
        int max = -1;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] >= K) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] + A[j] >= K) {
                    continue;
                } else {
                    max = Math.max(max, A[i] + A[j]);
                }
            }
        }
        return max;
    }
}
