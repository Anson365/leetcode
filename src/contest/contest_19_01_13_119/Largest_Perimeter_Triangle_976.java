package contest.contest_19_01_13_119;

import java.util.Arrays;

/**
 * Created by Anson on 1/13/19.
 */
public class Largest_Perimeter_Triangle_976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        for (int i = length - 1; i >= 2; i--) {
            int l1 = A[i];
            int l2 = A[i - 1];
            int l3 = A[i - 2];
            if (l1 < l2 + l3) {
                return l1 + l2 + l3;
            }
        }
        return 0;
    }
}
