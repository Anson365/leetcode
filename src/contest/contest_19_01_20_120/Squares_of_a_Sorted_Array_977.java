package contest.contest_19_01_20_120;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Anson on 2019/1/20.
 */
public class Squares_of_a_Sorted_Array_977 {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int i = 0, j = A.length - 1;
        for (int n = A.length - 1; n >= 0; n--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[n] = A[i] * A[i];
                i++;
            } else {
                result[n] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
