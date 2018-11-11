package contest.contest_18_11_11_110;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/11/18.
 */
public class Distinct_Subsequences_II_940 {
    public int distinctSubseqII_1(String S) {
        int mod = (int)1e9 + 7;
        int result = 0;
        int length = S.length();
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = (dp[i] + dp[j]) % mod;
                if (S.charAt(j) == S.charAt(i)) {
                    dp[i] -= 1;
                    break;
                }

            }
        }
        for (int temp : dp) {
            result = (result + temp) % mod;
        }
        return result;
    }

    public int distinctSubseqII(String S) {
        int mod = (int)1e9 + 7;
        long[] chars = new long[26];
        for (char c : S.toCharArray()) {
            chars[c - 'a'] = Arrays.stream(chars).sum() % mod + 1;
        }
        return (int)Arrays.stream(chars).sum() % mod;
    }
}
