package greedy;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/14/18.
 */
public class SmallestRangeII_910 {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int length = A.length, res = A[length - 1] - A[0];
        for (int i = 0; i < length - 1; i++) {
            int mx, mn;
            mx = Math.max(A[i] + K, A[length - 1] - K);
            mn = Math.min(A[i + 1] - K, A[0] + K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestRangeII_910 smallestRangeII_910 = new SmallestRangeII_910();
        smallestRangeII_910.smallestRangeII(new int[]{0, 10}, 6);
    }
}
