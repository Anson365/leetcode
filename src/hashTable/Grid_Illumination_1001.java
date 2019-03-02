package hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-03-01
 */
public class Grid_Illumination_1001 {

    private final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 },
            { 1, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 0, 0 } };

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> horMap = new HashMap<>();
        Map<Integer, Integer> vertMap = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        Set<String> grid = new HashSet<>();

        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            grid.add(hash(x, y));
            horMap.put(x, horMap.getOrDefault(x, 0) + 1);
            vertMap.put(y, vertMap.getOrDefault(y, 0) + 1);
            leftMap.put(x - y, leftMap.getOrDefault(x - y, 0) + 1);
            rightMap.put(x + y, rightMap.getOrDefault(x + y, 0) + 1);
        }

        int M = queries.length;
        int[] res = new int[M];
        int t = 0;
        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];

            int sum = 0;
            sum += horMap.getOrDefault(x, 0);
            sum += vertMap.getOrDefault(y, 0);
            sum += leftMap.getOrDefault(x - y, 0);
            sum += rightMap.getOrDefault(x + y, 0);
            sum += grid.contains(hash(x, y)) ? 1 : 0;

            res[t++] = sum > 0 ? 1 : 0;

            for (int[] direction : directions) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];

                if (!inBounds(nextX, nextY, N) || !grid.contains(hash(nextX, nextY))) {
                    continue;
                }
                if (horMap.get(nextX) != null && horMap.get(nextX) > 0) {
                    horMap.put(nextX, horMap.get(nextX) - 1);
                }

                if (vertMap.get(nextY) != null && vertMap.get(nextY) > 0) {
                    vertMap.put(nextY, vertMap.get(nextY) - 1);
                }

                if (leftMap.get(nextX - nextY) != null && leftMap.get(nextX - nextY) > 0) {
                    leftMap.put(nextX - nextY, leftMap.get(nextX - nextY) - 1);
                }
                if (rightMap.get(nextX + nextY) != null && rightMap.get(nextX + nextY) > 0) {
                    rightMap.put(nextX + nextY, rightMap.get(nextX + nextY) - 1);
                }
            }
        }
        return res;
    }

    private String hash(int x, int y) {
        return x + "-" + y;
    }

    private boolean inBounds(int r, int c, int N) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
