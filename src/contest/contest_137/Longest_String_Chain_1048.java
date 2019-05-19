package contest.contest_137;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-05-19
 */
public class Longest_String_Chain_1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        int length = words.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (helper(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private boolean helper(String s1, String s2) {
        if (s1.length() - s2.length() != 1) {
            return false;
        }
        int j = 0, diff = 0;
        for (int i = 0; i < s2.length() && j < s1.length(); i++) {
            if (s1.charAt(j) == s2.charAt(i)) {
                j++;
                continue;
            }
            j++;
            i--;
            diff++;
        }
        return diff <= 1;
    }
}
