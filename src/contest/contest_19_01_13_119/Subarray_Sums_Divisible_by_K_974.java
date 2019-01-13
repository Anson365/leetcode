package contest.contest_19_01_13_119;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson on 1/13/19.
 */
public class Subarray_Sums_Divisible_by_K_974 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for (int a : A) {
            sum += a;
            int mod = 0;
            if (sum < 0 && sum % K != 0) {
                mod = sum + K * (((-sum) / K) + 1);
            } else {
                mod = sum % K;
            }
            System.out.println(mod);
            if (mod == 0) {
                count++;
            }
            int freq = map.getOrDefault(mod, 0);
            map.put(mod, freq + 1);
            count += freq;
        }
        return count;
    }
}
