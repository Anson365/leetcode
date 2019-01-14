package interview.appannie;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/19/18.
 */
public class AppAnnie_Test3 {
    public int solution(int N) {
        String nStr = N + "";
        char[] array = nStr.toCharArray();
        Arrays.sort(array);
        long result = 0;
        for (int i = array.length - 1; i >=0; i--) {
            result = result * 10 + (array[i] - '0');
        }
        if (result > 1e9) {
            return -1;
        }
        return (int)result;

    }
}
