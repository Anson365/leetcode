package contest.contest_18_12_02_113;

import BaseConstruction.TreeNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/1/18.
 */
public class Reveal_Cards_In_Increasing_Order_950 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));

    }
}
