package contest.contest_159;

/**
 * @author Anson
 * Created on 2019-10-20
 */
class Contest1 {
    public boolean checkStraightLine(int[][] coordinates) {
        int row = coordinates.length;
        double k = (coordinates[row - 1][1] - coordinates[0][1]) * 1.0d / (coordinates[row - 1][0] - coordinates[0][0]);
        for (int i = 1; i < row - 1; i++) {
            if (k != (coordinates[i][1] - coordinates[0][1]) * 1.0d / (coordinates[i][0] - coordinates[0][0])) {
                return false;
            }
        }
        return true;
    }
}
