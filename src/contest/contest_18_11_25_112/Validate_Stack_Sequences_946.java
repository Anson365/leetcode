package contest.contest_18_11_25_112;

import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/25/18.
 */
public class Validate_Stack_Sequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length, poppedIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (pushed[i] != popped[poppedIndex]) {
                stack.push(pushed[i]);
            } else {
                poppedIndex++;
                while (!stack.isEmpty() && popped[poppedIndex] == stack.peek()) {
                    stack.pop();
                    poppedIndex++;
                }
            }
        }
        return poppedIndex == length;
    }
}
