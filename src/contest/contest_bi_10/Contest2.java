package contest.contest_bi_10;

import java.util.HashSet;
import java.util.Set;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-10-05
 */
class Contest2 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        dfs(root1, set);
        return dfs2(root2, set, target);
    }

    private void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }

    private boolean dfs2(TreeNode root, Set<Integer> set, int target) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        return dfs2(root.left, set, target) || dfs2(root.right, set, target);
    }
}
