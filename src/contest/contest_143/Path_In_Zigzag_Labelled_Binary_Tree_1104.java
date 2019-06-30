package contest.contest_143;

import java.util.Arrays;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-06-30
 */
public class Path_In_Zigzag_Labelled_Binary_Tree_1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int tmp = 1;
        int size = 0;
        while (label - tmp >= 0) {
            size++;
            tmp *= 2;
        }
        Integer[] result = new Integer[size];
        result[size - 1] = label;
        if (size % 2 == 0) {
            int start = (int) Math.pow(2, size - 1);
            int end = (int) Math.pow(2, size) - 1;
            label = end - label + start;
        }
        label /= 2;
        for (int i = size - 1; i > 0; i--) {
            if (i % 2 == 1) {
                result[i - 1] = label;
            } else {
                int start = (int) Math.pow(2, i - 1);
                int end = (int) Math.pow(2, i) - 1;
                result[i - 1] = end - label + start;
            }
            label /= 2;
        }
        return Arrays.asList(result);
    }
}
