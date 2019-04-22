package array;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-04-18
 */
public class Valid_Tic_Tac_Toe_State_2_794 {

    public boolean validTicTacToe(String[] board) {
        boolean xWin = false;
        boolean oWin = false;
        int[] column = new int[3];
        int[] row = new int[3];
        int diag = 0;
        int antiDiag = 0;
        int turns = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char tmp = board[i].charAt(j);
                if (tmp == 'X') {
                    column[j]++;
                    row[i]++;
                    turns++;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 2) {
                        antiDiag++;
                    }
                } else if (tmp == 'O') {
                    column[j]--;
                    row[i]--;
                    turns--;
                    if (i == j) {
                        diag--;
                    }
                    if (i + j == 2) {
                        antiDiag--;
                    }
                }
            }
        }
        xWin = Arrays.stream(column).anyMatch(t -> t == 3)
                || Arrays.stream(row).anyMatch(t -> t == 3) || diag == 3 || antiDiag == 3;

        oWin = Arrays.stream(column).anyMatch(t -> t == -3)
                || Arrays.stream(row).anyMatch(t -> t == -3) || diag == -3 || antiDiag == -3;
        System.out.println(xWin);
        System.out.println(oWin);

        if ((xWin && turns != 1) || (oWin && turns != 0)) {
            return false;
        }
        return (!xWin || !oWin) && (turns == 0 || turns == 1);
    }
}
