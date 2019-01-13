package contest.contest_19_01_13_119;

import java.util.TreeMap;

/**
 * Created by Anson on 1/13/19.
 */
public class Odd_Even_Jump_975 {
    public int oddEvenJumps(int[] A) {
        int length = A.length, count = 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        boolean[] odd = new boolean[length], even = new boolean[length];
        treeMap.put(A[length - 1], length - 1);
        odd[length - 1] = even[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            Integer evenIndex = treeMap.ceilingKey(A[i]), oddIndex = treeMap.floorKey(A[i]);
            if (evenIndex != null) {
                odd[i] = even[treeMap.get(evenIndex)];
                if (odd[i]) {
                    count++;
                }
            }
            if (oddIndex != null) {
                even[i] = odd[treeMap.get(oddIndex)];
            }
            treeMap.put(A[i], i);
        }
        return count;
    }
}
