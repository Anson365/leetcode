package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-02-13
 */
public class Generate_Parentheses_22 {
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper("", n, n);
        return result;
    }

    private void helper(String str, int left, int right) {
        if (left > right) {
            return;
        }
        if (left > 0) {
            helper(str + "(", left - 1, right);
        }
        if (right > 0) {
            helper(str + ")", left, right - 1);
        }
        if (left == right && left == 0) {
            result.add(str);
        }
    }
}
