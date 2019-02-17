package contest.contest_19_02_17_123;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-02-17
 */
public class Minimum_Number_of_K_Consecutive_Bit_Flips_995 {
    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        for (int i = 0; i <= A.length - K; i++) {
            if (A[i] != 1) {
                flip(A, i, K);
                count++;
            }
        }
        for (int a : A) {
            if (a != 1) {
                return -1;
            }
        }
        return count;
    }

    private void flip(int[] A, int start, int K) {
        for (int i = start; i < start + K; i++) {
            A[i] = A[i] ^ 1;
        }
        return;
    }
}
