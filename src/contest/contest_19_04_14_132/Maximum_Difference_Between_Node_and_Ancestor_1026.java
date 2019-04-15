package contest.contest_19_04_14_132;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-04-14
 */
public class Maximum_Difference_Between_Node_and_Ancestor_1026 {

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    private int helper(TreeNode root, int max, int min, int result) {
        if (root == null) {
            return 0;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        result = Math.max(max - root.val, root.val - min);
        int leftRes = helper(root.left, max, min, result);
        int rightRes = helper(root.right, max, min, result);
        result = Math.max(result, Math.max(leftRes, rightRes));
        return result;
    }


}
