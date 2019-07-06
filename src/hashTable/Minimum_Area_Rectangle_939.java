package hashTable;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author luodaihua
 * Created on 2019-07-05
 */
public class Minimum_Area_Rectangle_939 {

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = Arrays.stream(points)
                .collect(Collectors.groupingBy(t -> t[0],
                        Collectors.mapping(t -> t[1], Collectors.toSet())));
        int area = Integer.MAX_VALUE;
        for (int[] p : points) {
            for (int[] p1 : points) {
                if (p[0] == p1[0] || p[1] == p1[1]) {
                    continue;
                }
                if (map.get(p[0]).contains(p1[1]) && map.get(p1[0]).contains(p[1])) {
                    area = Math.min(area, Math.abs(p[0] - p1[0]) * Math.abs(p[1] - p1[1]));
                }
            }
        }
        return area == Integer.MAX_VALUE ? 0 : area;
    }

}
