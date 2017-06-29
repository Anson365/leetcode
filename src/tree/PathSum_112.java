package tree;

import BaseConstruction.TreeNode;

/**
 * Created by ludao on 2017/6/28.
 */
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&sum==root.val){
            return true;
        }
        Boolean left=false,right=false;
        left = hasPathSum(root.left,sum-root.val);
        right = hasPathSum(root.right,sum-root.val);
        return left||right;
    }
}
