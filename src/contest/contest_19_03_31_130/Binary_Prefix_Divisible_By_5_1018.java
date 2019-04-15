package contest.contest_19_03_31_130;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-03-31
 */
public class Binary_Prefix_Divisible_By_5_1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        long temp = 0;
        for (int a : A) {
            temp = temp * 2 + a;
            if (temp % 5 == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
            temp %= 5;
        }
        return result;
    }
}
