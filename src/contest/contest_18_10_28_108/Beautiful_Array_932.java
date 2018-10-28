package contest.contest_18_10_28_108;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/28/18.
 */
public class Beautiful_Array_932 {
    public int[] beautifulArray(int N) {
        List<Integer> list = helper(N);
        return list.stream().mapToInt(item -> (int)item).toArray();
    }

    private List<Integer> helper(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            list.add(1);
            return list;
        }
        int even = (n + 1) / 2, odd = n / 2;
        List<Integer> evenList = helper(even).stream().map(item -> item * 2 - 1).collect(Collectors.toList());
        List<Integer> oddList = helper(odd).stream().map(item -> item * 2 - 1).collect(Collectors.toList());
        list.addAll(evenList);
        list.addAll(oddList);
        return list;
    }
}
