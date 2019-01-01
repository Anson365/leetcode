package contest.contest_18_12_30_117;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anson on 12/30/18.
 */
public class Numbers_With_Same_Consecutive_Differences_967 {
    private Set<Integer> set = new HashSet<>();

    public int[] numsSameConsecDiff(int N, int K) {
        int start = N == 1 ? 0 : 1;
        for (int i = start; i <= 9; i++) {
            helper(i, N - 1, K, i);
        }
        return set.stream().mapToInt(item -> (int)item).toArray();
    }

    private void helper(int start, int n, int k, Integer temp) {
        if (n < 1) {
            set.add(temp);
            return;
        }
        if (start + k <= 9) {
            helper(start + k, n - 1, k, temp * 10 + start + k);
        }
        if (start - k >= 0) {
            helper(start - k, n - 1, k, temp * 10 + start - k);
        }
    }
}
