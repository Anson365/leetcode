package twopointer;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Anson on 1/16/19.
 */
public class Most_Profit_Assigning_Work_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            int d = difficulty[i];
            treeMap.put(d, Math.max(profit[i], treeMap.getOrDefault(d, 0)));
        }
        int tempMax = 0;
        for (Integer key : treeMap.keySet()) {
            tempMax = Math.max(treeMap.get(key), tempMax);
            treeMap.put(key, tempMax);
        }
        for (int i = 0; i < worker.length; i++) {
            int w = worker[i];
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(w);
            if (entry != null) {
                result += entry.getValue();
            }
        }
        return result;
    }
}
