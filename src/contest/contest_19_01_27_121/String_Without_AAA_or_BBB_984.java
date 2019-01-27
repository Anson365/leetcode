package contest.contest_19_01_27_121;

import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-01-27
 */
public class String_Without_AAA_or_BBB_984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        if (A > B) {
            for (int i = 0; i < B; i++) {
                 stack.push("ba");
            }
            int temp = A - B;
            if (temp >= 2) {
                sb.append("aa");
                temp -= 2;
            }
            while (!stack.empty()) {
                sb.append(stack.pop());
                if (temp > 0) {
                    sb.append("a");
                    temp--;
                }
            }
        } else {
            for (int i = 0; i < A; i++) {
                stack.push("ab");
            }
            int temp = B - A;
            if (temp >= 2) {
                sb.append("bb");
                temp -= 2;
            }
            while (!stack.empty()) {
                sb.append(stack.pop());
                if (temp > 0) {
                    sb.append("b");
                    temp--;
                }
            }
        }
        return sb.toString();
    }
}
