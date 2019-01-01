package dp;

/**
 * Created by Anson on 12/29/18.
 */
public class Dungeon_Game_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length, column = dungeon[0].length;
        int[][] dp = new int[row][column];
        dp[row - 1][column - 1] = Math.max(1, 1 - dungeon[row - 1][column - 1]);
        for (int i = column - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - dungeon[row - 1][i]);
        }

        for (int i = row - 2; i >= 0; i--) {
            dp[i][column - 1] = Math.max(1, dp[i + 1][column - 1] - dungeon[i][column - 1]);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                int temp1 = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                int temp2 = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                dp[i][j] =  Math.min(temp1, temp2);
            }
        }
        return dp[0][0];
    }


//    public static void main(String[] args) {
//        Dungeon_Game_174 dungeon_game_174 = new Dungeon_Game_174();
//        int[][] dungeon =  new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
//        dungeon_game_174.calculateMinimumHP(dungeon);
//    }
}
