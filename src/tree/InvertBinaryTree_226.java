package tree;

import BaseConstruction.TreeNode;

import java.util.Stack;

/**
 * Created by ludao on 2017/7/4.
 */
public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
