package contest.contest141;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luodaihua
 * Created on 2019-06-16
 */
public class Duplicate_Zeros_1089 {
    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(0);
            }
            list.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}
