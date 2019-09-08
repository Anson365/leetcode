package contest.contest_bi_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-09-07
 */
class Contest3 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            List<Integer> list = map.getOrDefault(colors[i], new ArrayList<>());
            list.add(i);
            map.put(colors[i], list);
        }
        for (int[] query : queries) {
            int index = query[0];
            int target = query[1];
            if (!map.containsKey(target)) {
                res.add(-1);
                continue;
            }
            List<Integer> indexs = map.get(target);
            int temp = Collections.binarySearch(indexs, index, Comparator.naturalOrder());
            if (temp >= 0) {
                res.add(0);
            } else {
                if (temp == -1) {
                    res.add(Math.abs(indexs.get(0) - index));
                } else {
                    temp = -temp;
                    if (temp > indexs.size()) {
                        res.add(Math.abs(indexs.get(indexs.size() - 1) - index));
                    } else  {
                        res.add(Math.min(Math.abs(indexs.get(temp - 1) - index), Math.abs(indexs.get(temp - 2) - index)));
                    }
                }
            }
        }
        return res;
    }
}
