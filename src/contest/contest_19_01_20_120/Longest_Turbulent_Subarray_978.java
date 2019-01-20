package contest.contest_19_01_20_120;

/**
 * Created by Anson on 2019/1/20.
 */
public class Longest_Turbulent_Subarray_978 {
    public int maxTurbulenceSize(int[] A) {
        Boolean up = null;
        int max = 1, count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (up == null) {
                    count++;
                    up = true;
                } else if (!up) {
                    up = true;
                    count++;
                } else {
                    max = Math.max(count, max);
                    count = 2;
                    up = true;
                }
            } else if (A[i] < A[i - 1]) {
                if (up == null) {
                    up = false;
                    count++;
                } else if (up) {
                    up = false;
                    count++;
                } else {
                    max = Math.max(count, max);
                    count = 2;
                    up = false;
                }
            } else {
                up = null;
                max = Math.max(count, max);
                count = 1;
            }
        }

        return Math.max(count, max);
    }
}
