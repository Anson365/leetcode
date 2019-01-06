package contest.contest_19_01_06_118;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Anson on 1/6/19.
 */
public class Powerful_Integers_970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        if (bound < 2) {
            return new ArrayList<>();
        }
        if (x == 1 && y == 1) {
            result.add(2);
        } else if (x == 1 || y == 1) {
            int temp = x == 1 ? y : x;
            while (temp <= bound - 1) {
                result.add(temp + 1);
                temp *= temp;
            }
            result.add(2);
        } else {
            for (int i = 0; Math.pow(x, i) <= bound - 1; i++) {
                for (int j = 0; Math.pow(y, j) + Math.pow(x, i) <= bound; j++) {
                    result.add((int) Math.pow(x, i) + (int) Math.pow(y, j));
                }
            }
        }
        return new ArrayList<>(result);
    }
}
