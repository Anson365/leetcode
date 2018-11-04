package contest.contest_18_11_04_109;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/4/18.
 */
public class Number_of_Recent_Calls_933 {
    private TreeMap<Integer, Integer> treeMap;
    private Integer count;
    public Number_of_Recent_Calls_933() {
        treeMap = new TreeMap<>();
        count = 1;
    }

    public int ping(int t) {
        treeMap.put(t, count);
        count++;
        return count - treeMap.get(treeMap.ceilingKey(t - 3000));
    }
}
