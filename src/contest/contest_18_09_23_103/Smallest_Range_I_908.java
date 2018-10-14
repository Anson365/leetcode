package contest.contest_18_09_23_103;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/23/18.
 */
public class Smallest_Range_I_908 {
    public int smallestRangeI(int[] A, int K) {
        if(A == null || A.length < 2) {
            return 0;
        }
        int max =Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int temp : A) {
            max = temp > max ? temp : max;
            min = temp < min ? temp : min;
        }
        int start = min + K;
        int end = max - K;
        if (start >= end) {
            return 0;
        } else {
            return end - start;
        }
    }
}
