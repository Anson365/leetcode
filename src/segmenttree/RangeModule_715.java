package segmenttree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author luodaihua
 * Created on 2019-01-31
 */
public class RangeModule_715 {

    TreeMap<Integer, Integer> map;

    public RangeModule_715() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (right <= left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (start == null && end == null) {
            map.put(left, right);
        } else if (start != null && map.get(start) >= left) {
            map.put(start, Math.max(map.get(end), Math.max(map.get(start), right)));
        } else {
            map.put(left, Math.max(map.get(end), right));
        }
        Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        Integer leftLimit = map.floorKey(left);
        if (leftLimit != null) {
            int leftValue = map.get(leftLimit);
            return leftValue >= right;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public static void main(String[] args) {
        RangeModule_715 rangeModule_715 = new RangeModule_715();
        rangeModule_715.addRange(5, 8);
        rangeModule_715.queryRange(3, 4);
        rangeModule_715.removeRange(5, 6);
        rangeModule_715.removeRange(3, 6);
        rangeModule_715.addRange(1, 3);
        rangeModule_715.queryRange(2, 3);
        rangeModule_715.addRange(4, 8);
        rangeModule_715.queryRange(2, 3);
        rangeModule_715.removeRange(4, 9);
    }

}
