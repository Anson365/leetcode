package contest.contest_155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-09-22
 */
class Contest1 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i - 1]);
            temp.add(arr[i]);
            if (diff < min) {
                min = diff;
                result = new ArrayList<>();
                result.add(temp);
            } else if (diff == min) {
                result.add(temp);
            }
        }
        return result;
    }
}
