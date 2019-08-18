package contest.contest_149;

/**
 * @author luodaihua
 * Created on 2019-08-11
 */
class Contest2 {

    private final int mod = (int) 1e7 + 7;

    public int numRollsToTarget(int d, int f, int target) {
        Integer[][] memo = new Integer[target + 1][d + 1];
        return helper(d, f, target, memo);
    }

    private int helper(int d, int f, int target, Integer[][] memo) {
        if (target < 0) {
            return 0;
        }
        if (d == 0 || f * d < target) {
            return 0;
        }
        if (d == 1 && target > f) {
            return 0;
        }
        if (d == 1 && f >= target) {
            return 1;
        }
        if (memo[target][d] != null) {
            return memo[target][d];
        }
        int sum = 0;
        for (int i = 1; i <= f; i++) {
            for (int j = 1; j < d; j++) {
                sum += (helper(j, f, target - i, memo)) % mod;
                sum %= mod;
            }
        }
        memo[target][d] = sum;
        return sum;
    }
}
