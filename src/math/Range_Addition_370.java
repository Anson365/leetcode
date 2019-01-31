package math;

/**
 * @author luodaihua
 * Created on 2019-01-29
 */
public class Range_Addition_370 {

    public int[] rangeAddition(int length, int[][] additions) {
        int[] result = new int[length];
        for (int[] addition : additions) {
            int start = addition[0];
            int end = addition[1];
            int step = addition[2];
            for (int i = start; i <= end; i++) {
                result[i] += step;
            }
        }
        return result;
    }
}
