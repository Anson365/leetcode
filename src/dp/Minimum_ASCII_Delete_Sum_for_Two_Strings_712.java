package dp;

/**
 * Created by Anson on 12/21/18.
 */
public class Minimum_ASCII_Delete_Sum_for_Two_Strings_712 {
    public int minimumDeleteSum(String s1, String s2) {
        int ls1 = s1.length();
        int ls2 = s2.length();
        int[][] dp = new int[ls1 + 1][ls2 + 1];
        for (int i = 0; i <= ls1; i++) {
            for (int j = 0; j <= ls2; j++) {
                if (i == 0 || j == 0) {
                    int temp = 0, limitation = Math.max(i, j);
                    for (int m = 0; m < limitation; m++) {
                        temp += (i == 0 ? s2.charAt(m) : s1.charAt(m));
                    }
                    dp[i][j] = temp;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int temp = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1] + s1.charAt(i - 1) + s2.charAt(j - 1));
                }
            }
        }
        return dp[ls1][ls2];
    }
}
