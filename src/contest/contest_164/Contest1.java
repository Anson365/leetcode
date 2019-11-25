package contest.contest_164;

/**
 * @author Anson
 * Created on 2019-11-24
 */
public class Contest1 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int row = points[0][0];
        int col = points[0][1];
        int step = 0;
        for (int i = 1; i < points.length; i++) {
            int nextRow = points[i][0];
            int nextCol = points[i][1];
            int diffRow = Math.abs(nextRow - row);
            int difCol = Math.abs(nextCol - col);
            step = step + Math.min(difCol, diffRow) + Math.abs(difCol - diffRow);
            row = nextRow;
            col = nextCol;
        }
        return step;
    }
}
