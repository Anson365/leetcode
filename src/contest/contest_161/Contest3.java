package contest.contest_161;

import java.util.Stack;

/**
 * @author Anson
 * Created on 2019-11-03
 */
class Contest3 {
    public String minRemoveToMakeValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.charAt(i) + "";
            if (!")".equals(temp)) {
                stack.push(temp);
            } else {
                String tempStr = "";
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if ("(".equals(pop)) {
                        stack.push("(" + tempStr + ")");
                        tempStr = "";
                        break;
                    } else if (!")".equals(pop)) {
                        tempStr = pop + tempStr;
                        continue;
                    }
                }
                if (!"".equals(tempStr)) {
                    stack.push(tempStr);
                }
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if ("(".equals(pop) || ")".equals(pop)) {
                continue;
            }
            result = pop + result;
        }
        return result;
    }

}
