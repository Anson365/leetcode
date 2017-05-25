package bfs;

/**
 * 结果中的O相邻必须包含边上的O，所以从四条边开始查找
 */
public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
            return;
        }
        int row = board.length;
        int column = board[0].length;
        //存放过滤后的O值
        char[][] tempBoard = new char[row][column];
        //从四个边开始遍历
        for(int i=0;i<row;i++){
            doSolve(i,0,board,tempBoard);
            doSolve(i,column-1,board,tempBoard);
        }
        for(int j=0;j<column;j++){
            doSolve(0,j,board,tempBoard);
            doSolve(row-1,j,board,tempBoard);
        }
        //过滤求结果
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(board[i][j]!='O'||board[i][j]!=tempBoard[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    private void doSolve(int i,int j,char[][] board,char[][] tempBoard){
        int row = board.length;
        int column = board[0].length;
        if(tempBoard[i][j]=='O'){
            return;
        }
        char tempChar = board[i][j];
        if(tempChar!='O') return;
        //如果当前边的值为O 查找其相邻的所有O值
        tempBoard[i][j]='O';
        if(i-1>=0&&j!=0&&j!=column){
            doSolve(i-1,j,board,tempBoard);
        }
        if(i+1<row&&j!=0&&j!=column){
            doSolve(i+1,j,board,tempBoard);
        }
        if(j-1>=0&&i!=0&&i!=row){
            doSolve(i,j-1,board,tempBoard);
        }
        if(j+1<column&&i!=0&&i!=row){
            doSolve(i,j+1,board,tempBoard);
        }
    }

    public static void main(String[] args){
    }
}
