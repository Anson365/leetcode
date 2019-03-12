package BaseConstruction;

import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-03-09
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
