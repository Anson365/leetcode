package stack;

import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-08-02
 */
public class Daily_Temperatures_739 {


    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[] {T[i], i});
            } else {
                while (!stack.isEmpty() && stack.peek()[0] < T[i]) {
                    int[] tempIndex = stack.pop();
                    result[tempIndex[1]] = i - tempIndex[1];
                }
                stack.push(new int[] {T[i], i});
            }
        }
        return result;
    }
}
