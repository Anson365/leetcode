package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/17/18.
 */
public class Count_Different_Palindromic_Subsequences_730 {
    public int countPalindromicSubsequences(String S) {
        int length = S.length();
        long[][] dp = new long[length][length];
        int mod = (int)(1e9) + 7;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int distance = 1; distance < length; distance++) {
            for (int begin = 0, end = begin + distance; end < length; begin++, end++) {
                if (S.charAt(begin) != S.charAt(end)) {
                    dp[begin][end] = (dp[begin + 1][end] + dp[begin][end - 1] - dp[begin + 1][end - 1]);
                } else {
                    int left = begin + 1, right = end - 1;
                    long temp = dp[begin + 1][end - 1] * 2;

                    while (left <= right && S.charAt(left) != S.charAt(begin)) {
                        left++;
                    }
                    while (right >= left && S.charAt(right) != S.charAt(end)) {
                        right--;
                    }
                    if (left > right) {
                        dp[begin][end] = temp + 2;
                    } else if (left == right) {
                        dp[begin][end] = temp + 1;
                    } else {
                        dp[begin][end] = temp - dp[left + 1][right - 1];
                    }
                }
            }
        }
        return (int) (dp[0][length - 1] % mod);
    }
}
