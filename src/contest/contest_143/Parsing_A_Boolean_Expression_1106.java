package contest.contest_143;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-06-30
 */
public class Parsing_A_Boolean_Expression_1106 {
    public boolean parseBoolExpr(String expression) {
        Set<Character> operSet = new HashSet<>();
        operSet.add('&');
        operSet.add('|');
        operSet.add('!');
        Set<Character> expSet = new HashSet<>();
        expSet.add('t');
        expSet.add('f');
        Stack<Character> operation = new Stack<>();
        Stack<Character> exp = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (operSet.contains(c)) {
                operation.push(c);
            } else if (expSet.contains(c)) {
                exp.push(c);
            } else if ('(' == c) {
                exp.push('(');
            } else if (')' == c) {
                char op = operation.pop();
                Boolean result = null;
                while (exp.peek() != '(') {
                    char ex = exp.pop();
                    if (result == null) {
                        result = (ex == 't');
                    }
                    if (op == '|') {
                        result |= (ex == 't');
                    } else if (op == '&') {
                        result &= (ex == 't');
                    } else {
                        result = !(ex == 't');
                    }
                }
                exp.pop();
                exp.push(result ? 't' : 'f');
            }
        }
        return exp.pop() == 't';
    }
}
