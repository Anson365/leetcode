package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/21/18.
 * https://leetcode.com/problems/is-subsequence/description/
 */
public class Is_Subsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int sStart = 0;
        for (int i = 0; i < t.length() && sStart < s.length(); i++) {
            if (s.charAt(sStart) == t.charAt(i)) {
                sStart++;
            }
        }
        return sStart == s.length();
    }
}
