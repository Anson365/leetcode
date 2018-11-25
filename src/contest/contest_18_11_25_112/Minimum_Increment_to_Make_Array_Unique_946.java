package contest.contest_18_11_25_112;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/25/18.
 */
public class Minimum_Increment_to_Make_Array_Unique_946 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                continue;
            } else {
                int temp = A[i - 1] - A[i] + 1;
                count += temp;
                A[i] += temp;
            }
        }
        return count;
    }
}
