package contest.contest_19_02_10_122;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-02-10
 */
public class Add_to_Array_Form_of_Integer_989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();
        int temp = 0, index = A.length - 1;
        while (K != 0 || index >= 0) {
            int curK = K % 10;
            K = K / 10;
            int curA = 0;
            if (index >= 0) {
                curA = A[index];
                index--;
            }
            int curResult = curA + curK + temp;
            temp = curResult / 10;
            ((LinkedList<Integer>) result).addFirst(curResult % 10);
        }
        if (temp != 0) {
            ((LinkedList<Integer>) result).addFirst(temp);
        }
        return result;
    }
}
