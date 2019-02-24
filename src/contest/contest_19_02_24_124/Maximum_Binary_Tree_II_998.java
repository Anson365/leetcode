package contest.contest_19_02_24_124;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-02-24
 */
public class Maximum_Binary_Tree_II_998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }



    public TreeNode insertIntoMaxTree1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        helper(root, val);
        return root;
    }

    private void helper(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            root.right = new TreeNode(val);
            return;
        }
        if (root.left != null && root.right != null) {
            int leftVal = root.left.val;
            int rightVal = root.right.val;
            if (val > leftVal && val > rightVal) {
                TreeNode treeNode = new TreeNode(val);
                treeNode.left = root.right;
                root.right = treeNode;
                return;
            } else if (val < leftVal && val < rightVal) {
                helper(root.right, val);
            } else {
                if (val > rightVal) {
                    TreeNode treeNode = new TreeNode(val);
                    treeNode.left = root.right;
                    root.right = treeNode;
                    return;
                } else {
                    helper(root.right, val);
                }
            }
        } else if (root.left == null) {
            int rightVal = root.right.val;
            if (val > rightVal) {
                TreeNode treeNode = new TreeNode(val);
                treeNode.left = root.right;
                root.right = treeNode;
                return;
            } else {
                helper(root.right, val);
            }
        } else if (root.right == null) {
            root.right = new TreeNode(val);
        }
    }
}
