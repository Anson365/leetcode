package contest.contest_19_02_17_123;

import java.util.HashMap;
import java.util.Map;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-02-17
 */
public class Cousins_in_Binary_Tree_993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, int[]> map = new HashMap<>();
        helper(map, root, 0);
        int[] left = map.get(x);
        int[] right = map.get(y);
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left[0] != right[0] && left[1] == right[1];
    }

    private void helper(Map<Integer, int[]> map, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        int parent = root.val;
        if (root.left != null) {
            map.put(root.left.val, new int[] { parent, depth + 1 });
            helper(map, root.left, depth + 1);
        }
        if (root.right != null) {
            map.put(root.right.val, new int[] { parent, depth + 1 });
            helper(map, root.right, depth + 1);
        }
    }
}
