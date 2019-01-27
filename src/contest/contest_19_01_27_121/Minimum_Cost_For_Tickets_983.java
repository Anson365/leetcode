package contest.contest_19_01_27_121;

/**
 * @author luodaihua
 * Created on 2019-01-27
 */
public class Minimum_Cost_For_Tickets_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            dp[i] = dp[i - 1] + costs[0];
            for (int j = i - 1; j >= 0; j--) {
                if (days[i - 1] - days[j] < 7) {
                    dp[i] = Math.min(dp[i], dp[j] + costs[1]);
                }
                if (days[i - 1] - days[j] < 30) {
                    dp[i] = Math.min(dp[i], dp[j] + costs[2]);
                }
            }
        }
        return dp[length];
    }
}
