package backtracking;

/**
 * 回溯（backtracking）
 * 回溯法采用试错的思想，它尝试分步的去解决一个问题。
 * 在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算（试错非必须，可能存在全是正确的场景）
 * 再通过其它的可能的分步解答再次尝试寻找问题的答案。
 * 回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
 *      1.找到一个可能存在的正确的答案
 *      2.在尝试了所有可能的分步方法后宣告该问题没有答案
 * 回溯的典型算法例题 8皇后问题（https://zh.wikipedia.org/wiki/%E5%85%AB%E7%9A%87%E5%90%8E%E9%97%AE%E9%A2%98）
 *
 * 附加题：1.请打印出字母abcd 组合而成的所有字符长度为四的字符串 其中字母可以重复
 *        2.将例题中的8皇后替换为n皇后
 */
public class EightQueens {
    private int result = 0;
    public int helper() {
        boolean[][] board = new boolean[8][8];//定义8x8的棋盘
        dfs(board, 0); //从第一行开始放皇后
        return result;
    }
    public void dfs(boolean[][] board, int row) { //dfs深度优先遍历
        if(row == 8) { //放完了最后一行，即满足8皇后共存条件结果+1
            result++;
            return;
        }
        for(int i=0;i<8;i++){    //从第row行的第一列依次尝试放入皇后
            board[row][i] = true;//标记放入皇后的位置
            if(check(board, row, i)){ //校验当前皇后是否合理
                dfs(board, row + 1); //合理则开始进行放下一行的皇后
            }
            board[row][i] = false; //当前位置不满足（check为false）或者尝试完改点的所有情况后，置空，开始对下一列进行尝试
        }
    }
    private boolean check(boolean[][] position, int row, int col) {
        for(int i=0;i<8;i++){         //依次对每一列进行合法校验
            for(int j=0;j<row;j++){   //依次遍历每一行
                if(position[j][i]  //当前位置有皇后
                        &&(row+i==col+j||row+col==i+j||col==i))//两条对角线和所在列的情况
                    return false;  //说明有冲突 不满足条件
            }
        }
        return true;//遍历玩所有的情况 满足条件
    }
}
