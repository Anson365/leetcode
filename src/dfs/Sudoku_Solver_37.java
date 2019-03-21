package dfs;

/**
 * @author luodaihua
 * Created on 2019-03-18
 */
public class Sudoku_Solver_37 {

    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }

    public boolean solve(int i, int j, char[][] board) {
        if (i == 9 && ++j == 9) {
            return true;
        }
        if (i == 9) {
            i = 0;
        }
        if (board[i][j] != '.') {
            return solve(i + 1, j, board);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(i, j, board, c)) {
                board[i][j] = c;
                if (solve(i + 1, j, board)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    public boolean isValid(int rowIndex, int colIndex, char[][] board, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][colIndex] == c) return false;
            if (board[rowIndex][i] == c) return false;
        }

        int row = (rowIndex / 3) * 3;
        int col = (colIndex / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + row][j + col] == c) return false;
            }
        }
        return true;
    }
}
