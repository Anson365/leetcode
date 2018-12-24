package contest.contest_18_11_04_109;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/4/18.
 */
public class Knight_Dialer_935 {

    private static final int MOD = 1000000007;

    public int knightDialer(int N) {
       int[][] graph = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {0,1,7}, {2, 6}, {1, 3}, {2, 4}};
       Integer[][] memo = new Integer[N][10];
       int cnt = 0;
       for (int i = 0; i < 10; i++) {
           cnt = (cnt + helper(N - 1, i, graph, memo)) % MOD;
       }
       return cnt;

    }

    private int helper(int n, int cur, int[][] graph, Integer[][] memo) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][cur] != null) {
            return memo[n][cur];
        }
        int cnt = 0;
        for (int next : graph[cur]) {
            cnt = (cnt + helper(n - 1, next, graph, memo)) % MOD;
        }
        memo[n][cur] = cnt;
        return cnt;
    }

//    public static void main(String[] args) {
//        Knight_Dialer_935 knightDialer935 = new Knight_Dialer_935();
//        knightDialer935.knightDialer(3);
//
//    }

}
