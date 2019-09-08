package contest.contest_152;

import java.math.BigDecimal;
import java.util.TreeMap;

/**
 * @author luodaihua
 * Created on 2019-09-01
 */
class Contest1 {

    private long mod = (long)10e9 + 7;
    private static TreeMap<Integer, Integer> map;
    static {
        int[] temp = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
                67, 71, 73, 79, 83, 89, 97 };
        map = new TreeMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], i);
        }
    }

    public int numPrimeArrangements(int n) {
        if (n <= 2) {
            return 1;
        }
        int pc = count(n);
        int left = n - pc;
        long temppc = helper(pc);
        return (int)temppc;
    }

    private int count(int n) {
        return map.floorEntry(n).getValue() + 1;
    }

    private long helper(int n) {
        long temp = 1;
        for (int i = n; i > 0; i--) {
            temp *= i;
            temp %= mod;
        }
        return (temp % mod);
    }
}
