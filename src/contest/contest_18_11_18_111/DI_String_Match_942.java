package contest.contest_18_11_18_111;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/18/18.
 */
public class DI_String_Match_942 {
    public int[] diStringMatch(String S) {
        int negative = 0, positive = 0;
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                result[i + 1] = ++positive;
            } else {
                result[i + 1] = --negative;
            }
        }
        for (int i = 0; i < S.length(); i++) {
            result[i] -= negative;
        }
        return result;
    }
}
