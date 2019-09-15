package contest.contest_154;

import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-09-15
 */
class Contest2 {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    sb.append(new StringBuilder(stack.pop()).reverse());
                }
                if (!stack.isEmpty() && "(".equals(stack.peek())) {
                    stack.pop();
                }
                stack.push(sb.toString());
            } else {
                stack.push(c + "");
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}
