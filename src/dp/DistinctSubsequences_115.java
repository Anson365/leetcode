package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 8/19/18.
 */
public class DistinctSubsequences_115 {


    public int numDistinct(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < slength ; i++) {
            for (int j = tlength - 1; j >= 0 ; j--) {
                if (s.charAt(i) == t.charAt(j) && j <= i) {
                    dp[j+1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}
