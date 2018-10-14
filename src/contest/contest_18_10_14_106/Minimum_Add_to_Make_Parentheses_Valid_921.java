package contest.contest_18_10_14_106;

import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/14/18.
 */
public class Minimum_Add_to_Make_Parentheses_Valid_921 {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            }
        }
        count += stack.size();
        return count;
    }
}
