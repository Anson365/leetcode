package dp;

/**
 * @author luodaihua
 * Created on 2019-04-12
 */
public class Decode_Ways_91 {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) != '0') {
                int temp = Integer.parseInt(s.substring(i- 2, i));
                if (temp >= 1 && temp <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            if (dp[i] == 0) {
                return 0;
            }
        }
        return dp[s.length()];
    }
}
