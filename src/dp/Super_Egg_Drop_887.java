package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/7/18.
 */
public class Super_Egg_Drop_887 {
    public int superEggDrop_1(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }
        return m;
    }


}
