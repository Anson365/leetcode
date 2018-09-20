package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/20/18.
 */
public class Factor_Combinations_254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 2, n);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int start, int n) {
        if (n == 1) {
            if (list.size() != 1) {//remove itself which n/n = 1
                result.add(list);
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(result, new ArrayList<>(list), i, n / i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Factor_Combinations_254 factor_combinations_254 = new Factor_Combinations_254();
        factor_combinations_254.getFactors(32);
    }
}
