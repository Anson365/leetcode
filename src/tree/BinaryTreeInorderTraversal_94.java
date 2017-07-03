package tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ludao on 2017/7/3.
 * 二叉树的中序遍历 LDR
 */

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        recursionLDR(root,result);
        return result;
    }

    private void recursionLDR(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        //left
        recursionLDR(root.left,list);
        //middle
        list.add(root.val);
        //right
        recursionLDR(root.right,list);
    }

    public List<Integer> inorderTraversalNonRecursion(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }


}
