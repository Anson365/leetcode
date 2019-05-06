package contest.contest_19_04_28_134;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-04-28
 */
public class Moving_Stones_Until_Consecutive_1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] array = new int[] {a, b, c};
        Arrays.sort(array);
        int diff1 = array[1] - array[0] - 1;
        int diff2 = array[2] - array[1] - 1;
        if (diff1 == 0 && diff2 == 0) {
            return new int[] {0, 0};
        }
        if (diff1 == 0 || diff2 == 0) {
            return new int[] {1, Math.max(diff1, diff2)};
        }
        return new int[] {Math.min(Math.min(diff1, diff2), 2), diff1 + diff2};
    }
}
