package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-01-21
 */
public class Combinations_77 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(0, n, k, new ArrayList<>());
        return result;
    }

    private void helper(int start, int n, int k, List<Integer> list) {
        if (k == 0) {
            result.add(list);
            return;
        }
        for (int i = start + 1; i <= n - k + 1; i++) {
            list.add(i);
            helper(i, n, k - 1, new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations_77 combinations_77 = new Combinations_77();
        combinations_77.combine(3, 2);
    }
}
