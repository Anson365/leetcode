package contest.contest_19_03_03_125;

import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-03-03
 */
public class Check_If_Word_Is_Valid_After_Substitutions_1003 {

    public boolean isValid(String S) {
        while (S.length() > 3) {
            String temp = S.replaceAll("abc", "");
            if (S.equals(temp)) {
                break;
            }
            S = temp;
        }
        return "abc".equals(S) || "".equals(S);
    }

    public boolean isValid2(String S) {
        if (S == null) return false;
        Stack<Character> stk = new Stack<Character>();
        for (char ch : S.toCharArray()) {
            if (ch == 'c') {
                if (stk.isEmpty() || stk.peek() != 'b') return false;
                stk.pop();
                if (stk.isEmpty() || stk.peek() != 'a') return false;
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        return stk.isEmpty();
    }
}
