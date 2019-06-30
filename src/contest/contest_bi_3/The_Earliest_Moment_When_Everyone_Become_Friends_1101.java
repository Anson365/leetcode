package contest.contest_bi_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-06-29
 */
public class The_Earliest_Moment_When_Everyone_Become_Friends_1101 {

    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (log1, log2) -> log1[0] - log2[0]);
        int[] memo = new int[N];
        for (int i = 0; i < N; i++) {
            memo[i] = i;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int[] log : logs) {
            int left = Math.min(log[1], log[2]);
            int right = Math.max(log[1], log[2]);
            if (memo[left] == 0 || memo[right] == 0) {
                if (memo[right] == 0 && memo[left] == 0) {
                    continue;
                }
                int temp = Math.max(memo[right], memo[left]);
                memo[right] = 0;
                memo[left] = 0;
                set.add(right);
                set.add(left);
                for (int i = 1; i < N; i++) {
                    if (memo[i] == temp) {
                        memo[i] = 0;
                        set.add(i);
                    }
                }
                if (set.size() == N) {
                    return log[0];
                }
            } else {
                int max = Math.max(memo[right], memo[left]);
                int min = Math.min(memo[right], memo[left]);
                memo[right] = min;
                memo[left] = min;
                for (int i = 1; i < N; i++) {
                    if (memo[i] == max) {
                        memo[i] = min;
                    }
                }
            }
        }
        return -1;
    }
}
