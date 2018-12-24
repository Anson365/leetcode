package dp;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/19/18.
 */
public class Distinct_Subsequences_115 {
    public int numDistinct(String s, String t) {
        int slength = s.length(), tlength = t.length();
        int[][] dp = new int[tlength + 1][slength + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < tlength + 1; i++) {
            for (int j = 1; j < slength + 1; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tlength][slength];
    }

//    public static void main(String[] args) {
//        Distinct_Subsequences_115 distinct_subsequences_115 = new Distinct_Subsequences_115();
//        distinct_subsequences_115.numDistinct("babgbag", "bag");
//    }
}
