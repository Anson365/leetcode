package stack;

import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-08-21
 */
class Evaluate_Reverse_Polish_Notation_150 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token == "+") {
                token = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop()) + "";
            } else if (token == "*") {
                token = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop()) + "";
            } else if (token == "\\") {
                int t1 = Integer.parseInt(stack.pop());
                int t2 = Integer.parseInt(stack.pop());
                token = t2 / t1 + "";
            }
            stack.push(token);
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation_150 reversePolishNotation150 = new Evaluate_Reverse_Polish_Notation_150();
        reversePolishNotation150.evalRPN(new String[] { "2", "1", "+", "3", "*" });
    }
}
