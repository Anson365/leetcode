package contest.contest_138;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-05-26
 */
public class Height_Checker_1051 {
    public int heightChecker(int[] heights) {
        int[] tmp = Arrays.copyOf(heights, heights.length);
        Arrays.sort(tmp);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (tmp[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
