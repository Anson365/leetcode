package contest.contest_18_11_18_111;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/18/18.
 */
public class Delete_Columns_To_Make_Sorted_944 {
    public int minDeletionSize(String[] A) {
        int count = 0;
        int length = A.length;
        for (int j =0; j < A[0].length(); j++) {
            for (int i = 1; i < length; i++) {
                String a = A[i - 1];
                String b = A[i];
                if (a.charAt(j) >b.charAt(j)) {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
}
