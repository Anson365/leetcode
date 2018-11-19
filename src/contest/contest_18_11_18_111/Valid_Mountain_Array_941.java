package contest.contest_18_11_18_111;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/18/18.
 */
public class Valid_Mountain_Array_941 {
    public boolean validMountainArray(int[] A) {
        int length = A.length;
        if (length < 3) {
            return false;
        }
        int up = 1, down = length - 2;
        while (up < length) {
            if (A[up] > A[up - 1]) {
                up++;
            } else {
                break;
            }
        }

        while (down >= 0) {
            if (A[down] > A[down + 1]) {
                down--;
            } else {
                break;
            }
        }
        return (up - 1 == down + 1) && (up > 1) && (down < length - 2);
    }
}
