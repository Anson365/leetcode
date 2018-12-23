package array;

import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/10/18.
 */
public class Maximal_Rectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[] temp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            char[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (matrix[i][j] == '1') {
                    temp[j] += 1;
                } else {
                    temp[j] = 0;
                }
            }
            max = Math.max(max, findTempMax(temp));
        }
        return max;
    }

    private int findTempMax(int[] temp) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= temp.length; i++) {
            int height = i == temp.length ? 0 : temp[i];
            while (!stack.isEmpty() && height < temp[stack.peek()]) {
                int preHeight = temp[stack.pop()];
                max = Math.max(max, preHeight * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
            stack.push(i);
        }
        return max;
    }

//    public static void main(String[] args) {
//        Maximal_Rectangle_85 maximal_rectangle_85 = new Maximal_Rectangle_85();
//        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        maximal_rectangle_85.maximalRectangle(matrix);
//    }
}
