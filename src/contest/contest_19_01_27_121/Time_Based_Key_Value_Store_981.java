package contest.contest_19_01_27_121;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author luodaihua
 * Created on 2019-01-27
 */
public class Time_Based_Key_Value_Store_981 {
    private Map<String, TreeMap<Integer, String>> timeMap;

    /** Initialize your data structure here. */
    public Time_Based_Key_Value_Store_981() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = timeMap.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        timeMap.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = timeMap.get(key);
        if (treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> temp = treeMap.floorEntry(timestamp);
        if (temp == null) {
            return "";
        }
        return temp.getValue();
    }
}
