package contest.contest_19_02_24_124;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;

/**
 * @author luodaihua
 * Created on 2019-02-24
 */
public class Find_the_Town_Judge_997 {

    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        Arrays.stream(trust).forEach(t -> {
            count[t[0]]--;
            count[t[1]]++;
        });
        for (int i = 0; i < N + 1; i++) {
            if (count[i] == N - 1) {
                return i;
            }
        }
        return  -1;
    }

    public int findJudge2(int N, int[][] trust) {
        boolean[] temp = new boolean[N];
        for (int i = 0; i < trust.length; i++) {
            int index = trust[i][0];
            temp[index - 1] = true;
        }
        int result = -1;
        for (int i = 0; i < N; i++ ) {
            if (temp[i]) {
                continue;
            }
            if (result != -1) {
                return -1;
            }
            result = i + 1;
        }
        if (result == -1) {
            return result;
        }
        temp = new boolean[N];
        for (int i = 0; i < trust.length; i++) {
            int index = trust[i][0];
            if (trust[i][1] == result) {
                temp[index - 1] = true;
            }
        }
        for (int i = 0; i < N; i++ ) {
            if (!temp[i] && i != result - 1) {
                return -1;
            }
        }
        return result;
    }
}
