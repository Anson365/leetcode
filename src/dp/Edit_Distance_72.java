package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/10/18.
 */
public class Edit_Distance_72 {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int temp = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]);
                    dp[i + 1][j + 1] = ++temp;
                }
            }
        }
        return dp[length1][length2];
    }
}
