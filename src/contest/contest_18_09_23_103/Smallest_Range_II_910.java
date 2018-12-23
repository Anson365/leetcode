package contest.contest_18_09_23_103;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/23/18.
 */
public class Smallest_Range_II_910 {
    public int smallestRangeII(int[] A, int K) {
        if(A == null || A.length < 2) {
            return 0;
        }
        Arrays.sort(A);
        int maxGap = A[A.length - 1] - A[0] ;
        if (maxGap <= K || 2*K >= maxGap) {
            return maxGap;
        }
        int sum = Arrays.stream(A).sum();
        int avg = sum / A.length;
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            if (temp > avg) {
                A[i] = temp - K;
            } else {
                A[i] = temp + K;
            }
        }
        Arrays.sort(A);
        int result = A[A.length - 1] - A[0];
        return result;
    }

//    public static void main(String[] args) {
//        Smallest_Range_II_910 smallest_range_ii_910 = new Smallest_Range_II_910();
//        int[] A = {0, 10};
//        smallest_range_ii_910.smallestRangeII(A, 2);
//    }
}
