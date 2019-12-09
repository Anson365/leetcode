package contest.contest_166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Anson
 * Created on 2019-12-08
 */
class Contest2 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            List<List<Integer>> list = map.getOrDefault(size, new ArrayList<>());
            if (list.size() == 0) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                list.add(tempList);
            } else {
                List<Integer> tempList = list.get(list.size() - 1);
                if (tempList.size() < size) {
                    tempList.add(i);
                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(i);
                    list.add(newList);
                }
            }
            map.put(size, list);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<List<Integer>> list : map.values()) {
            res.addAll(list);
        }
        return res;
    }

}
