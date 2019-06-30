package contest.contest_bi_3;

/**
 * @author luodaihua
 * Created on 2019-06-29
 */
public class Find_K_Length_Substrings_With_No_Repeated_Characters_1100 {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (K > S.length()) {
            return 0;
        }
        StringBuilder temp = new StringBuilder();
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int index = temp.indexOf(c + "");
            if (index > -1) {
                temp = new StringBuilder(temp.toString().substring(index + 1, temp.toString().length()));
                temp.append(c);
                if (temp.length() == K) {
                    result++;
                }
            } else {
                temp = temp.append(c);
                if (temp.length() == K + 1) {
                    result++;
                    temp = new StringBuilder(temp.subSequence(1, K + 1));
                } else if (temp.length() == K) {
                    result++;
                }
            }
        }
        return result;
    }
}
