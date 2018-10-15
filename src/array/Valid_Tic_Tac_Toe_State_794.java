package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/15/18.
 */
public class Valid_Tic_Tac_Toe_State_794 {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        String tempStr = board[0] + board[1] + board[2];
        for (char c : tempStr.toCharArray()) {
            if (c == 'X') xCount++;
            else if (c == 'O') oCount++;
        }
        if (xCount < oCount || oCount + 1 < xCount) return false;
        boolean xwin = false, owin = false;
        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'X') xwin = true;
            else if (board[0].charAt(0) == 'O') owin = true;
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            if (board[0].charAt(2) == 'X') xwin = true;
            else if (board[0].charAt(2) == 'O') owin = true;
        }
        for (int i = 0; i < 3; i++) {
            String temp = board[i];
            if (temp.charAt(0) == temp.charAt(1) && temp.charAt(0) == temp.charAt(2)) {
                if (temp.charAt(0) == 'X') xwin = true;
                else if (temp.charAt(0) == 'O') owin = true;
            }
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'X') xwin = true;
                else if (board[0].charAt(i) == 'O') owin = true;
            }
        }
        if (!(xwin ^ owin)) return !xwin;
        if (owin) return xCount == oCount;
        if (xwin) return xCount - oCount == 1;
        return true;
    }

    public static void main(String[] args) {
        Valid_Tic_Tac_Toe_State_794 valid_tic_tac_toe_state_794 = new Valid_Tic_Tac_Toe_State_794();
        valid_tic_tac_toe_state_794.validTicTacToe(new String[] {"X  ","   ","  O"});
    }

}
