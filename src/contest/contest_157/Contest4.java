package contest.contest_157;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-10-06
 */
public class Contest4 {
    private int mod = (int)1e9 + 7;
    public int countVowelPermutation(int n) {
        long endA = 1, endE = 1, endI = 1, endO = 1, endU = 1;
        long sum = 5;
        for (int i = 1; i < n; i++) {
            long tempA = (endE + endU + endI) % mod;
            long tempE = (endA + endI) % mod;
            long tempI = (endE + endO) % mod;
            long tempO = endI % mod;
            long tempU = (endI + endO) % mod;
            sum = tempA + tempE + tempI + tempO + tempU;
            sum %= mod;
            endA = tempA;
            endE = tempE;
            endI = tempI;
            endO = tempO;
            endU = tempU;
        }
        return (int)sum;
    }
}
