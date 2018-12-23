package tree;

import BaseConstruction.TreeNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/19/18.
 */
public class Subtree_Of_Another_Tree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (doJudge(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean doJudge(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return doJudge(s.left, t.left) && doJudge(s.right, t.right);
    }


}
