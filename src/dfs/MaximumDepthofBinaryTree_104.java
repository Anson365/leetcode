package dfs;

import BaseConstruction.TreeNode;

/**
 * Created by ludao on 2017/6/28.
 */
public class MaximumDepthofBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
