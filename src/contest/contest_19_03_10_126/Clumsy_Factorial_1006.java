package contest.contest_19_03_10_126;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-03-10
 */
public class Clumsy_Factorial_1006 {

    public int clumsy(int N) {
        List<Integer> listInteger = new ArrayList<>();
        List<String> listOperation = new ArrayList<>();
        String[] operation = new String[] { "*", "/", "+", "-" };
        int temp = N;
        for (int i = N - 1; i > 0; i--) {
            int index = (N - i - 1) % 4;
            String curOp = operation[index];
            if ("*".equals(curOp)) {
                temp *= i;
            } else if ("/".equals(curOp)) {
                temp /= i;
            } else {
                listInteger.add(new Integer(temp));
                listOperation.add(curOp);
                temp = i;
            }
        }
        listInteger.add(temp);
        int result = listInteger.get(0);
        int next = 1;
        for (String op : listOperation) {
            if ("+".equals(op)) {
                result += listInteger.get(next++);
            } else {
                result -= listInteger.get(next++);
            }
        }
        return result;
    }
}
