package contest.contest_137;

import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-05-19
 */
public class Remove_All_Adjacent_Duplicates_In_String_1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
