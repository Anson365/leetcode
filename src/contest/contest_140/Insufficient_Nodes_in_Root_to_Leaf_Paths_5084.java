package contest.contest_140;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-06-09
 */
public class Insufficient_Nodes_in_Root_to_Leaf_Paths_5084 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, 0, limit);
    }

    private TreeNode helper(TreeNode root, int sum, int limit) {
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                root.left = helper(root.left, sum + root.val, limit);
            }
            if (root.right != null) {
                root.right = helper(root.right, sum + root.val, limit);
            }
            if (root.left == null && root.right == null) {
                return null;
            } else {
                return root;
            }
        } else {
            if (sum + root.val >= limit) {
                return root;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        Insufficient_Nodes_in_Root_to_Leaf_Paths_5084
                insufficientNodesinRoottoLeafPaths5084 = new Insufficient_Nodes_in_Root_to_Leaf_Paths_5084();
        insufficientNodesinRoottoLeafPaths5084.sufficientSubset(node, 4);
    }
}
