package contest.contest_139;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-06-02
 */
public class Adding_Two_Negabinary_Numbers_1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int length = Math.max(length1, length2);
        int[] result = new int[length + 2];
        for (int i = 0; i < length; i++) {
            int forward = 0;
            int i1 = length1 - i - 1;
            int i2 = length2 - i - 1;
            if (i1 >= 0) {
                forward += arr1[i1];
            }
            if (i2 >= 0) {
                forward += arr2[i2];
            }
            forward += result[length + 1 - i];
            if (forward >= 0) {
                int tmp = forward % 2;
                result[length + 1 - i] = tmp;
                result[length - i] = -(forward / 2);
            } else {
                result[length + 1 - i] = 1;
                result[length - i] = 1;
            }
        }
        if (result[1] < 0) {
            result[0] = 1;
            result[1] = 1;
            return result;
        } else {
            int index = 0;
            while (index < length + 2 && result[index] == 0) {
                index++;
            }
            if (index >= length + 2) {
                return new int[] { 0 };
            }
            return Arrays.copyOfRange(result, index, length + 2);
        }
    }
}
