package dfs;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/4/18.
 */
public class Flood_Fill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] mark = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        helper(image, mark, sr, sc, newColor, oldColor);
        return image;
    }

    private void helper(int[][] image, boolean[][] mark, int sr, int sc, int newColor, int oldColor) {
        // out of range
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        int current = image[sr][sc];
        boolean edited = mark[sr][sc];
        // not equal and had been edited
        if (current != oldColor || edited) {
            return;
        }
        mark[sr][sc] = true;
        image[sr][sc] = newColor;
        //up
        helper(image, mark, sr, sc - 1, newColor, oldColor);
        //down
        helper(image, mark, sr, sc + 1, newColor, oldColor);
        //left
        helper(image, mark, sr - 1, sc, newColor, oldColor);
        //right
        helper(image, mark, sr + 1, sc, newColor, oldColor);
    }
}
