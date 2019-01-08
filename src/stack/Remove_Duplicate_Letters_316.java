package stack;

import java.util.Stack;

/**
 * Created by Anson on 1/8/19.
 */
public class Remove_Duplicate_Letters_316 {
    public String removeDuplicateLetters(String s) {
        int[] memo = new int[26];
        boolean[] visited = new boolean[26];
        char[] ch = s.toCharArray();
        for (char c : ch) {
            memo[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : ch) {
            int index = c - 'a';
            memo[index]--;
            if (visited[index]) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek() && memo[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
