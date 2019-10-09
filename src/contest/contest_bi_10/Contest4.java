package contest.contest_bi_10;

/**
 * @author luodaihua
 * Created on 2019-10-05
 */
public class Contest4 {

    private int isKPalDP(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public boolean isValidPalindrome(String str, int k) {
        return isKPalDP(str, new StringBuilder(str).reverse().toString(), str.length(),
                str.length()) <= k * 2;
    }
}
