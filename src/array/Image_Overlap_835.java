package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/20/18.
 */
public class Image_Overlap_835 {
    public int largestOverlap(int[][] A, int[][] B) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = A.length, result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result = Math.max(result, helper(A, B, i, j));
            }
        }
        return result;
    }

    private int helper(int[][] A, int[][] B, int x, int y) {

        int count = 0, length = A.length;
        for (int i = 0; i < length - x; i++) {
            for (int j =0; j < length; j++) {
                if (B[i][j] == 1 && A[i + x][j + y] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
