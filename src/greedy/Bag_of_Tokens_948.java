package greedy;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/9/18.
 */
public class Bag_of_Tokens_948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int start = 0, end = tokens.length - 1, p = 0, result = 0;
        while (start <= end) {
            if (tokens[start] > P) {
                if (p == 0) {
                    return result;
                } else {
                    p--;
                    P += tokens[end];
                    end--;
                }
            } else {
                P -= tokens[start];
                p++;
                result = Math.max(p, result);
                start++;
            }
        }
        return result;
    }
}
