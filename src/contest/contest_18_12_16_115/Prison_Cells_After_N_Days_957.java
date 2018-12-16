package contest.contest_18_12_16_115;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/16/18.
 */
public class Prison_Cells_After_N_Days_957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N <= 0) {
            return cells;
        }
        Map<String, Integer> map = new HashMap<>();
        int[] result = new int[cells.length];
        Boolean findFreq = false;
        for (int i = 1; i <= N; i++) {
            if (!findFreq && map.containsKey(Arrays.toString(cells))){
                int freq = i - map.get(Arrays.toString(cells));
                N = (N - i) % freq + i;
                findFreq = true;
            }
            for (int j = 1; j < cells.length - 1; j++) {
                result[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }
            map.put(Arrays.toString(cells), i);
            cells = result;
            result = new int[cells.length];

        }
        return cells;
    }
}
