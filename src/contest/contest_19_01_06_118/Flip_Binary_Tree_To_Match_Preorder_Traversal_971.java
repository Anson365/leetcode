package contest.contest_19_01_06_118;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson on 1/6/19.
 */
public class Flip_Binary_Tree_To_Match_Preorder_Traversal_971 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        int temp = helper(root, voyage, 0);
        if (temp == -1) {
            result = new ArrayList<>();
            result.add(-1);
        }
        return result;
    }


    private int helper(TreeNode root, int[] voyage, int index) {
        if(root == null || index >= voyage.length) {
            return index;
        }

        if (root.val != voyage[index]) {
            return -1;
        }

        int left = helper(root.left, voyage, index + 1);
        if (left != -1) { // no need flip
            return helper(root.right, voyage, left);
        }
        result.add(root.val);
        int right = helper(root.right, voyage, index + 1);
        if (right != -1) {
            return helper(root.left, voyage, right);
        }
        return -1;
    }

//    public static void main(String[] args) {
//        Flip_Binary_Tree_To_Match_Preorder_Traversal_971 contest3 = new Flip_Binary_Tree_To_Match_Preorder_Traversal_971();
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.left.left = new TreeNode(3);
//        contest3.flipMatchVoyage(treeNode, new int[]{2, 1});
//    }
}
