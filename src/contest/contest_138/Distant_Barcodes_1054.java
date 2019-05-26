package contest.contest_138;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author luodaihua
 * Created on 2019-05-26
 */
public class Distant_Barcodes_1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            int freq = map.getOrDefault(barcode, 0);
            map.put(barcode, freq + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (entry1, entry2) -> entry2.getValue() - entry1.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }
        int length = barcodes.length;

        Integer[] tmp = new Integer[length];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = priorityQueue.poll();
            int j = 0;
            int tmpCount = entry.getValue();
            while (j < tmpCount) {
                if (tmp[i] == null) {
                    tmp[i] = entry.getKey();
                    i += 2;
                    j++;
                } else {
                    i++;
                }
                if (i >= length) {
                    i = 0;
                }
            }
        }
        return Arrays.stream(tmp).mapToInt(t -> (int) t).toArray();
    }
}
