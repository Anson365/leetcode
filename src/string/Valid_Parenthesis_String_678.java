package string;

import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/23/18.
 */
public class Valid_Parenthesis_String_678 {
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int count, int index) {
        if (count < 0) {
            return false;
        }
        for (int i = index; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                count++;
            } else if (temp == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            } else {
                return helper(s, count + 1, i + 1) || helper(s,count - 1, i + 1) || helper(s, count, i + 1);
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Valid_Parenthesis_String_678 valid_parenthesis_string_678 = new Valid_Parenthesis_String_678();
        valid_parenthesis_string_678.checkValidString("()");
    }
}
