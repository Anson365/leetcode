package contest.contest_147;

/**
 * @author luodaihua
 * Created on 2019-07-28
 */
public class N_th_Tribonacci_Number_1137 {

    public int tribonacci(int n) {
        int[] memo = new int[35];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (memo[n] == 0 && n != 0) {
            int temp = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);
            memo[n] = temp;
            return temp;
        } else {
            return memo[n];
        }
    }
}
