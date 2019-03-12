package contest.contest_19_03_10_126;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-03-10
 */
public class Maximize_Sum_Of_Array_After_K_Negations_1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                break;
            } else {
                index = i;
            }
        }
        int min = Arrays.stream(A).map(Math::abs).min().getAsInt();
        int sum = Arrays.stream(A).map(Math::abs).sum();

        if (index == -1) {
            if (K % 2 == 0) {
                return sum;
            } else {
                return sum - 2 * min;
            }
        }
        if (index - K < 0) {
            int tempK = K - index;
            if (tempK % 2 == 0) {
                return sum - 2 * min;
            } else {
                return sum;
            }
        } else {
            for (int i = K; i <= index; i++) {
                sum += 2 * A[i];
            }
        }
        return sum;
    }
}
