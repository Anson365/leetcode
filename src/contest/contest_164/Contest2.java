package contest.contest_164;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anson
 * Created on 2019-11-24
 */
public class Contest2 {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            Set<String> tmpSet = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    tmpSet.add(i + "_" + j);
                }
            }
            if (tmpSet.size() > 1) {
                set.addAll(tmpSet);
            }
        }

        for (int j = 0; j < col; j++) {
            Set<String> tmpSet = new HashSet<>();
            for (int i = 0; i < row; i++) {
                if (grid[i][j] == 1) {
                    tmpSet.add(i + "_" + j);
                }
            }
            if (tmpSet.size() > 1) {
                set.addAll(tmpSet);
            }
        }
        return set.size();
    }
}
