package contest.contest_19_05_05_135;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-05-05
 */
public class Binary_Search_Tree_to_Greater_Sum_Tree_1038 {
    public TreeNode bstToGst_1(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int right) {
        if (root == null) {
            return right;
        }
        int val = root.val;
        int tmpRight = dfs(root.right, right);
        root.val = val + tmpRight;
        int left = dfs(root.left, root.val);
        return left;
    }

    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
