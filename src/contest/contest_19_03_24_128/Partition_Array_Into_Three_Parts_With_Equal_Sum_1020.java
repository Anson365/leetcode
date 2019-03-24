package contest.contest_19_03_24_128;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-03-24
 */
public class Partition_Array_Into_Three_Parts_With_Equal_Sum_1020 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        int target = 0;
        if (sum % 3 != 0) {
            return false;
        }
        if (sum < 0) {
            target = - Math.abs(sum) / 3;
        } else {
            target = sum / 3;
        }
        int temp = 0, freq = 0;
        for (int i = 0; i < A.length; i++) {
            temp += A[i];
            if (temp == target) {
                freq++;
                temp = 0;
            }
        }
        return freq == 3;
    }
}
