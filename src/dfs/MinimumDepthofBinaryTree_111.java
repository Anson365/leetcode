package dfs;

import BaseConstruction.TreeNode;

/**
 * Created by ludao on 2017/6/28.
 */
public class MinimumDepthofBinaryTree_111 {


    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0||right==0){
            return left+right+1;
        }
        return Math.min(left+1,right+1);
    }
}