package unionfind;

/**
 * Created by Anson on 1/15/19.
 */
public class Friend_Circles_547 {

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        Friend_Circles_547 friend_circles_547 = new Friend_Circles_547();
        friend_circles_547.findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}});
    }
}
