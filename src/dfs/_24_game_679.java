package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-03-11
 */
public class _24_game_679 {


    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        Arrays.stream(nums).forEach(item -> list.add((double)item));
        return helper(list);
    }

    private boolean helper(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 0.001;
        }

        for (int i = 0; i < list.size(); i++) {
             for (int j = i + 1; j < list.size(); j++) {
                 double item1 = list.get(i);
                 double item2 = list.get(j);

                 List<Double> nextList = new ArrayList<>();

                 for (int k = 0; k < list.size(); k++) {
                     if (k != j && k != i) {
                         nextList.add(list.get(k));
                     }
                 }

                 for (double temp : getAllPossibbleResult(item1, item2)) {
                     nextList.add(temp);
                     if (helper(nextList)) {
                         return true;
                     }
                     nextList.remove(nextList.size() - 1);
                 }
             }
        }
        return false;
    }

    private List<Double> getAllPossibbleResult(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        res.add(a / b);
        res.add(b / a);
        return res;
    }

}
