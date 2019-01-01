package contest.contest_18_12_30_117;

import BaseConstruction.TreeNode;

/**
 * Created by Anson on 12/30/18.
 */
public class Univalued_Binary_Tree_965 {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root.val, root.left) && helper(root.val, root.right);
    }

    private boolean helper(int target, TreeNode root) {
        if (root == null) {
            return true;
        }
        return target == root.val && helper(target, root.left) && helper(target, root.right);
    }
}
