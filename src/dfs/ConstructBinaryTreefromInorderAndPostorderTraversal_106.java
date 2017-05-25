package dfs;

import BaseConstruction.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ludao on 2017/4/18.
 */
public class ConstructBinaryTreefromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inorderMap = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,postorder.length-1,0,postorder.length,inorderMap);

    }

    private TreeNode buildTree(int[] inorder,int[] postorder,int rootIndex,int start,int end,Map<Integer,Integer> inorderMap){
        if(start==end) return null;
        int rootValue = postorder[rootIndex];
        int index = inorderMap.get(rootValue);
        if(index == end) return  null;
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(inorder,postorder,rootIndex-(end-index),start,index,inorderMap);
        root.right = buildTree(inorder,postorder,rootIndex-1,index+1,end,inorderMap);
        return root;
    }
}
