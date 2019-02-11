package math;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-02-11
 */
public class Three_Equal_Parts_927 {
    public int[] threeEqualParts(int[] A) {
        int[] result = new int[]{-1, -1};
        int sum = Arrays.stream(A).filter(i -> i == 1).sum();
        if (sum == 0) {
            return new int[]{0, 2};
        }
        if (sum % 3 != 0) {
            return result;
        }

        int length = sum / 3;
        int index0 = -1, index1 = -1, index2 = -1;
        sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 1) {
                continue;
            }
            sum++;
            if (sum == length + 1) {
                index1 = i;
            } else if (sum == 2 * length + 1) {
                index2 = i;
            } else if (sum == 1) {
                index0 = i;
            }
        }

        while (index2 < A.length) {
            if (A[index2] == A[index0] && A[index2] == A[index1]) {
                index2++;
                index1++;
                index0++;
            } else {
                return result;
            }
        }
        result[0] = index0 - 1;
        result[1] = index1;
        return result;
    }
}
