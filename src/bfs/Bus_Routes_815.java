package bfs;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/26/18.
 */
public class Bus_Routes_815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }

        Map<Integer, Set<Integer>> router = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int temp : routes[i]) {
                router.putIfAbsent(temp, new HashSet<>());
                Set<Integer> set = router.get(temp);
                set.add(i);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);
        visited.add(S);
        int result = 0;
        while (!q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int cur = q.poll();
                if (cur == T) {
                    return result;
                }
                for (int j : router.get(cur)) {
                    for (int temp : routes[j]) {
                        if (!visited.contains(temp)) {
                            q.offer(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
