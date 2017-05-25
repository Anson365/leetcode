package dfs;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/4/17.
 */
public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        LDR(root,list);
        Boolean result = true;
        for(int i=0;i<(list.size()-1)&&result;i++){
            result = list.get(i)<list.get(i+1);
        }
        return result;
    }

    private void LDR(TreeNode leaf,List<Integer> list) {
        if(leaf==null){
            return ;
        }
        LDR(leaf.left,list);
        list.add(leaf.val);
        LDR(leaf.right,list);
    }


    public static void main(String[] args) {
        ValidateBinarySearchTree_98 validateBinarySearchTree_98 = new ValidateBinarySearchTree_98();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        Boolean result = validateBinarySearchTree_98.isValidBST(treeNode);
        System.out.println(result);
    }
}
