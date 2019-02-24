package contest.contest_19_02_24_124;

/**
 * @author luodaihua
 * Created on 2019-02-24
 */
public class Available_Captures_for_Rook_999 {

    private int count = 0;
    public int numRookCaptures(char[][] board) {
        int[] rook = findRook(board);
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            find(board, direction, rook[0], rook[1]);
        }
        return count;
    }

    private void find(char[][] board, int[] direction, int i, int j) {
        if (i + direction[0] < 0 || i + direction[0] >= 8 || j + direction[1] < 0
                || j + direction[1] >= 8) {
            return;
        }
        int tempI = i + direction[0];
        int tempJ = j + direction[1];
        char temp = board[tempI][tempJ];
        if (temp == '.') {
            find(board, direction, tempI, tempJ);
        } else if (temp == 'p') {
            count++;
        } else {
            return;
        }
    }

    private int[] findRook(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
