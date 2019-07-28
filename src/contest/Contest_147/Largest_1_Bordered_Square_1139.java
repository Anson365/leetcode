package contest.Contest_147;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-07-28
 */
public class Largest_1_Bordered_Square_1139 {

    public int largest1BorderedSquare(int[][] grid) {
        Set<Integer>[] rows = new HashSet[grid.length];
        Set<Integer>[] columns = new HashSet[grid[0].length];

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            rows[i] = new HashSet<>();
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i].add(j);
                    if (columns[j] == null) {
                        columns[j] = new HashSet<>();
                    }
                    columns[j].add(i);
                    max = 1;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            Set<Integer> tmpRows = rows[i];
            for (int j : tmpRows) {
                int tmp = helper(rows, columns, i, j);
                max = Math.max(tmp, max);
            }
        }
        return max;
    }

    private int helper(Set<Integer>[] rows, Set<Integer>[] columns, int i, int j) {
        int maxRow = rows.length;
        int maxColumn = columns.length;
        int tmpI = i;
        int tmpJ = j;
        int max = 0;
        while (judge(tmpI + 1, tmpJ + 1, maxRow, maxColumn)) {
            tmpI++;
            tmpJ++;
            if (!rows[tmpI].contains(tmpJ) || !columns[tmpJ].contains(tmpI)) {
                continue;
            }
            if (!isSquare(i, j, tmpI, tmpJ, rows, columns)) {
                continue;
            }
            max = Math.max((tmpJ - j + 1) * (tmpI - i + 1), max);
        }
        return max;
    }

    private boolean isSquare(int i, int j, int tmpI, int tmpJ, Set<Integer>[] rows,
            Set<Integer>[] columns) {
        for (int m = i; m <= tmpI; m++) {
            if (!rows[m].contains(j) || (!rows[m].contains(tmpJ))) {
                return false;
            }
        }
        for (int n = j; n < tmpJ; n++) {
            if (!columns[n].contains(i) || (!columns[n].contains(tmpI))) {
                return false;
            }
        }
        return true;
    }

    private boolean judge(int i, int j, int maxRow, int maxColumn) {
        if (i < 0 || i >= maxRow || j < 0 || j >= maxColumn) {
            return false;
        }
        return true;
    }


    public int largest1BorderedSquare_2(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int hor[][] = new int[m][n];
        int ver[][] = new int[m][n];
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    hor[i][j] = j == 0? 1 : hor[i][j-1] + 1;
                    ver[i][j] = i == 0? 1 : ver[i-1][j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int edge = Math.min(hor[i][j], ver[i][j]);
                while(edge > max){
                    if(ver[i][j-edge+1] >= edge && hor[i-edge+1][j] >= edge) max = edge;
                    edge--;
                }
            }
        }
        return max * max;
    }
}
