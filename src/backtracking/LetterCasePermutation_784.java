package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/22/18.
 */
public class LetterCasePermutation_784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S.length() == 0) {
            result.add(S);
            return result;
        }
        String temp = S.toLowerCase();
        dfs(0, temp, result);
        return result;
    }

    private void dfs(int index, String temp, List<String> result) {
        if (index <= temp.length()) {
            result.add(temp);
        }
        for (int i = index; i < temp.length(); i++) {
            if (Character.isDigit(temp.charAt(i))) {
                continue;
            }
            String newStr;
            if (i + 1 < temp.length()) {
                newStr = temp.substring(0, i) + temp.substring(i, i + 1).toUpperCase() + temp.substring(i + 1);
            } else {
                newStr = temp.substring(0, i) + temp.substring(i, i + 1).toUpperCase();
            }
            dfs(i + 1, newStr, result);
        }
    }
}
