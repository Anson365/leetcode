package contest.contest_19_03_17_127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-03-17
 */
public class Pairs_of_Songs_With_Total_Durations_Divisible_by_60_1013 {

    public int numPairsDivisibleBy60_1(int[] time) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int temp = time[i];
            List<Integer> list = map.getOrDefault(temp % 10, new ArrayList<>());
            list.add(temp);
            map.put(temp % 10, list);
        }
        for (int i = 0; i <= 5; i++) {
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            if (list.size() == 0) {
                continue;
            }
            List<Integer> targetList = map.getOrDefault((10 - i) % 10, new ArrayList<>());
            if (targetList.size() == 0) {
                continue;
            }
            if (i == 0 || i == 5) {
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        if ((list.get(j) + list.get(k)) % 60 == 0) {
                            count++;
                        }
                    }
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < targetList.size(); k++) {
                        if ((list.get(j) + targetList.get(k)) % 60 == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int c[] = new int[60], res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}
