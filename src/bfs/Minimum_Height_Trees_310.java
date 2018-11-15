package bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/13/18.
 */
public class Minimum_Height_Trees_310 {

    public List<Integer> findMinHeightTrees_LTE(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if (n  < 3) {
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            return list;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] temp : edges) {
            Set<Integer> node1 = map.getOrDefault(temp[0], new HashSet<>());
            Set<Integer> node2 = map.getOrDefault(temp[1], new HashSet<>());
            node1.add(temp[1]);
            node2.add(temp[0]);
            map.put(temp[0], node1);
            map.put(temp[1], node2);
        }
        int mht = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = findMHT(-1, i, 0, map);
            if (temp < mht) {
                list.clear();
                list.add(i);
                mht = temp;
            } else if (temp == mht) {
                list.add(i);
            }
        }
        return list;

    }

    private int findMHT(int prenode, int currentNode,int depth, Map<Integer, Set<Integer>> map) {
        Set<Integer> set = map.get(currentNode);
        if (set.size() == 1 && prenode != -1) {
            return depth;
        }
        int mht = 0;
        for (Integer node : set) {
            if (node == prenode) {
                continue;
            }
            int temp = findMHT(currentNode, node,depth + 1, map);
            mht = Math.max(mht, temp);
        }
        return mht;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n < 3) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        List<Set<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leave : leaves) {
                Integer temp = list.get(leave).iterator().next();
                Set<Integer> tempSet = list.get(temp);
                tempSet.remove(leave);
                if (tempSet.size() == 1) {
                    newLeaves.add(temp);
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        Minimum_Height_Trees_310 minimum_height_trees_310 = new Minimum_Height_Trees_310();
        minimum_height_trees_310.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }
}
