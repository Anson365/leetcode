package array;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-02-15
 */
public class Increasing_Triplet_Subsequence_334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min)  {
                min = num;
            } else if (num <= smin) {
                smin = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
