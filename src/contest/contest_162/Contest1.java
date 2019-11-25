package contest.contest_162;

/**
 * @author Anson
 * Created on 2019-11-10
 */
class Contest1 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] temp = new int[n][m];

        for(int[] index : indices) {
            int row = index[0];
            int column = index[1];
            for (int i = 0; i < m; i++) {
                temp[row][i]++;
            }
            for (int i = 0; i < n; i++) {
                temp[i][column]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
