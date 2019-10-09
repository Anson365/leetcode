package contest.contest_bi_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author luodaihua
 * Created on 2019-10-05
 */
class Contest3 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> countSteppingNumbers(int low, int high) {
        for (int i = 0; i <= 9; i++) {
            bfs(low, high, i);
        }
        return list;
    }

    public void bfs(int low, int high, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()) {
            int stepNum = q.poll();
            if (stepNum <= high && stepNum >= low) {
                list.add(stepNum);
            }
            if (stepNum == 0 || stepNum > high) {
                continue;
            }
            int lastDigit = stepNum % 10;
            int stepNumA = stepNum * 10 + (lastDigit - 1);
            int stepNumB = stepNum * 10 + (lastDigit + 1);
            if (lastDigit == 0) q.add(stepNumB);
            else if (lastDigit == 9) {
                q.add(stepNumA);
            } else {
                q.add(stepNumA);
                q.add(stepNumB);
            }
        }
    }

}
