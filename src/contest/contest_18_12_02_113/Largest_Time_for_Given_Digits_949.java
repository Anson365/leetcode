package contest.contest_18_12_02_113;

import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/1/18.
 */
public class Largest_Time_for_Given_Digits_949 {
    public String largestTimeFromDigits(int[] A) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int a : A) {
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }

        Integer a = treeMap.floorKey(2);
        while (a != null) {
            String temp = doBuild(treeMap, a);
            if (temp != "") {
                return temp;
            } else {
                a = treeMap.floorKey(a - 1);
            }
        }
        return "";
    }

    private void removeKey(TreeMap<Integer, Integer> treeMap, int key) {
        int temp = treeMap.get(key);
        if (temp - 1 == 0) {
            treeMap.remove(key);
        } else {
            treeMap.put(key, temp - 1);
        }
    }

    private String doBuild(TreeMap<Integer, Integer> treeMap, Integer a) {
        treeMap = new TreeMap<>(new TreeMap<>(treeMap));
        StringBuilder result = new StringBuilder();
        result.append(a);
        removeKey(treeMap, a);
        Integer b = null;
        if (a == 2) {
            b = treeMap.floorKey(3);
        } else {
            b = treeMap.floorKey(9);
        }
        if (b == null) {
            return "";
        }
        result.append(b).append(":");
        removeKey(treeMap, b);

        Integer c = treeMap.floorKey(5);
        if (c == null) {
            return "";
        }
        result.append(c);
        removeKey(treeMap, c);

        Integer d = treeMap.floorKey(9);
        if (d == null) {
            return "";
        }
        result.append(d);
        removeKey(treeMap, d);
        return result.toString();
    }

//    public static void main(String[] args) {
//        Largest_Time_for_Given_Digits_949 contest1 = new Largest_Time_for_Given_Digits_949();
//        contest1.largestTimeFromDigits(new int[]{2,0,6,6});
//    }
}
