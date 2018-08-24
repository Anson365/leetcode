package stack;

import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 8/24/18.
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            if (!("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))) {
                nums.push(Integer.valueOf(token));
            } else  {
                Integer number1 = nums.pop();
                Integer number2 = nums.pop();
                Integer temp = null;
                switch (token) {
                    case "+":
                        temp = number2 + number1;
                        break;
                    case "-":
                        temp = number2 - number1;
                        break;
                    case "*":
                        temp = number2 * number1;
                        break;
                    case "/":
                        temp = number2 / number1;
                        break;
                }
                nums.push(temp);
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 erpn = new EvaluateReversePolishNotation_150();
        String[] tokens = {"2","1","+","3","*"};
        erpn.evalRPN(tokens);
    }
}
