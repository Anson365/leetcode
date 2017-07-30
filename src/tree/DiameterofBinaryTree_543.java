package tree;

import BaseConstruction.TreeNode;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/7/30.
 */
public class DiameterofBinaryTree_543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return max;
        diameterOfNode(root);
        return max;
    }


    private int diameterOfNode(TreeNode treeNode){
        if(treeNode==null){
            return 0;
        }
        int left = diameterOfNode(treeNode.left);
        int right = diameterOfNode(treeNode.right);


        max = Math.max(max,left+right);
        return Math.max(left,right)+1;

    }
}
