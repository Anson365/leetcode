package contest.contest_bi_4;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-07-13
 */
public class Maximum_Average_Subtree_1120 {

    private double max = 0;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }
    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0D, 0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        double sum = left.left + right.left;
        int count = left.right + right.right;
        sum += root.val;
        max = Math.max(sum / (count + 1), max);
        return new Pair(sum, count + 1);
    }

    static class Pair {

        double left;
        int right;

        Pair(double left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
