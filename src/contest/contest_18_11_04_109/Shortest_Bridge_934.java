package contest.contest_18_11_04_109;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/4/18.
 */
public class Shortest_Bridge_934 {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> island = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs_foundIsland(i, j, A, visited, island);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        while (!island.isEmpty()) {
            int size = island.size(); // mark current step scope;
            while (size-- > 0) {
                int[] cur = island.poll();
                for (int[] direct : directions) {
                    int i = cur[0] + direct[0];
                    int j = cur[1] + direct[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
                        if (A[i][j] == 1) {
                            return step;
                        } else { // expand
                            island.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private void dfs_foundIsland(int i, int j, int[][] A, boolean[][] visited, Queue<int[]> island) {
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] || A[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        island.offer(new int[]{i, j});
        for (int[] direct : directions) {
            dfs_foundIsland(i + direct[0], j + direct[1], A, visited, island);
        }
    }

}
