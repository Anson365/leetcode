package contest.contest_bi_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-10-05
 */
class Contest1 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < arr1.length && i2 < arr2.length && i3 < arr3.length) {
            if (arr1[i1] == arr2[i2] && arr2[i2] == arr3[i3]) {
                result.add(arr1[i1]);
                i1++;
                i2++;
                i3++;
            } else {
                int min = Math.min(Math.min(arr1[i1], arr2[i2]), arr3[i3]);
                if (arr1[i1] == min) {
                    i1++;
                }
                if (arr2[i2] == min) {
                    i2++;
                }
                if (arr3[i3] == min) {
                    i3++;
                }
            }
        }
        return result;
    }
}
