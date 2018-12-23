package contest.contest_18_12_23_116;

/**
 * Created by Anson on 12/23/18.
 */
public class N_Repeated_Element_in_Size_2N_Array_961 {
    public int repeatedNTimes(int[] A) {
        int p0 = 0, p1 = 1, p2 = 2, p = 3;
        if (A[p0] == A[p1] || A[p0] == A[p2]) {
            return A[p0];
        }
        if (A[p2] == A[p1]) {
            return A[p2];
        }

        while (p < A.length) {
            if (A[p] == A[p0] || A[p] == A[p1] || A[p] == A[p2]) {
                return A[p];
            }
            p0++;
            p1++;
            p2++;
            p++;
        }
        return -1;
    }
}
