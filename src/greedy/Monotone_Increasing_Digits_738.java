package greedy;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/11/18.
 */
public class Monotone_Increasing_Digits_738 {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        char[] result = new char[chars.length];
        Arrays.fill(result, (char) (9 + '0'));
        char temp = chars[0];
        for (int i = 0; i < result.length; i++) {
            if (chars[i] >= temp) {
                result[i] = chars[i];
                temp = chars[i];
            } else {
                result[i] = '9';
                result[i - 1] -= 1;
                for (int j = i - 2; j >= 0; j--) {
                    if (result[j] > result[j + 1]) {
                        result[j + 1] = '9';
                        result[j] -= 1;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return Integer.valueOf(new String(result));
    }
}
