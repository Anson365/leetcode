package contest.contest_19_01_13_119;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Anson on 1/13/19.
 */
public class K_Closest_Points_to_Origin_973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(item -> item[0] * item[0] + item[1] * item[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
