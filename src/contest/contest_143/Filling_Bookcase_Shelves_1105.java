package contest.contest_143;

/**
 * @author luodaihua
 * Created on 2019-06-30
 */
public class Filling_Bookcase_Shelves_1105 {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        for (int i = 1; i < books.length + 1; i++) {
            dp[i] = dp[i - 1] + books[i - 1][1];
            int tempWidth = books[i - 1][0];
            int tempHeight = books[i - 1][1];
            for (int j = i - 1; j > 0; j--) {
                if (tempWidth + books[j - 1][0] <= shelf_width) {
                    tempHeight = Math.max(tempHeight, books[j - 1][1]);
                    dp[i] = Math.min(dp[j - 1] + tempHeight, dp[i]);
                    tempWidth += books[j - 1][0];
                } else {
                    break;
                }
            }
        }
        return dp[books.length];
    }
}
