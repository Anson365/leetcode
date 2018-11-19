package contest.contest_18_11_18_111;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/18/18.
 */
public class Contest4 {
    public String shortestSuperstring(String[] A) {
        for (int i = 0; i < A.length; i++) {

        }
        return null;
    }
    private int dp(String[] A, int start, int end) {
        String a = A[start];
        String b = A[end];
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
