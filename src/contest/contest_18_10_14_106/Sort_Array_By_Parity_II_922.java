package contest.contest_18_10_14_106;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/14/18.
 */
public class Sort_Array_By_Parity_II_922 {
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int tempA = 0, tempB = 1;
        for (int temp : A) {
            if (temp % 2 == 0) {
                result[tempA] = temp;
                tempA += 2;
            } else {
                result[tempB] = temp;
                tempB += 2;
            }
        }
        return result;
    }
}
