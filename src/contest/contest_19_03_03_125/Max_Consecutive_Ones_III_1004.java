package contest.contest_19_03_03_125;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-03-03
 */
public class Max_Consecutive_Ones_III_1004 {
    public int longestOnes(int[] A, int K) {
        int max = 0, startIndex = 0;

        if (A.length == 0) {
            return 0;
        }
        if (K == 0) {
            int temp = 0;
            for (int a : A) {
                if (a == 1) {
                    temp++;
                } else {
                    max = Math.max(temp, max);
                }
            }
            return max;
        }
        LinkedList<Integer> listIndex = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (listIndex.size() < K) {
                    listIndex.addLast(i);
                } else {
                    startIndex = listIndex.removeFirst() + 1;
                    listIndex.addLast(i);
                }
            }
            max = Math.max(max, i - startIndex + 1);
        }
        return max;
    }

}
