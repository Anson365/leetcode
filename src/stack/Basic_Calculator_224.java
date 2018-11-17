package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/16/18.
 */
public class Basic_Calculator_224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int temp = Integer.valueOf(c - '0');
                while (Character.isDigit(s.codePointAt(i + 1))) {
                    temp = temp * 10 + Integer.valueOf(s.codePointAt(i + 1) - '0');
                    i++;
                }
                result += sign * temp;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }


}
