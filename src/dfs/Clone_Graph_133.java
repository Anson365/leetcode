package dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import BaseConstruction.Node;

/**
 * @author luodaihua
 * Created on 2019-03-09
 */
public class Clone_Graph_133 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> clones = new HashMap<>();
        return dfs(clones, node);
    }


    private Node dfs(Map<Node, Node> clones, Node node) {
        Node clone = new Node(node.val, new LinkedList<>());
        clones.put(node, clone);
        for (Node neighbor : node.neighbors) {
            if (!clones.containsKey(neighbor)) {
                dfs(clones, neighbor);
            }
        }

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(clones.get(neighbor));
        }
        return clone;
    }
}
