package backtracking;

/**
 * Created by ludao on 2017/7/21.
 */
public class NQueens2_52 {

    private int result = 0;
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        dfs(board,0);
        return result;
    }

    private void dfs(boolean[][] board,int colIndex){
        int n = board.length;
        if(colIndex==n){
            result++;
            return;
        }
        for(int i=0;i<n;i++){
            board[i][colIndex]=true;
            if(validate(board,i,colIndex)){
                dfs(board,colIndex+1);
            }
            board[i][colIndex]=false;
        }
    }

    private boolean validate(boolean[][] board,int x,int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]==true
                        &&(x+j==y+i||x+y==i+j||x==i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        NQueens2_52 nQueens2_52 = new NQueens2_52();
        nQueens2_52.totalNQueens(4);
    }
}
