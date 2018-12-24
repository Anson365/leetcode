package bfs;

import BaseConstruction.TreeNode;

/**
 * Created by ludao on 2017/4/12.
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return symmetricCheck(root.left,root.right);
    }

    private boolean symmetricCheck(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left==right;
        }
        if(left.val!=right.val){
            return false;
        }
        return symmetricCheck(left.left,right.right)&&symmetricCheck(left.right,right.left);
    }



    public boolean isSymmetricLDR(TreeNode root){
        if(root==null){
            return true;
        }
        StringBuilder treeValeStr = ldr(new StringBuilder(),root);
        String treeValue = treeValeStr.toString();
        int i=0,j=treeValue.length()-1;
        while (i<j){
            if(treeValue.charAt(i)==treeValue.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    private StringBuilder ldr(StringBuilder treeValeStr,TreeNode treeNode){
        if(treeNode==null){
            return treeValeStr;
        }else{
            return ldr(treeValeStr,treeNode.left).append(treeNode.val).append(ldr(new StringBuilder(),treeNode.right));
        }
    }

//    public static void main(String[] args){
//        TreeNode leave1 = new TreeNode(2);
//        TreeNode leave2 = new TreeNode(3);
//        TreeNode leave3 = new TreeNode(3);
//        TreeNode leave4 = new TreeNode(2);
//        TreeNode leave5 = new TreeNode(1);
//        leave5.left = leave4;
//        leave5.right = leave3;
//        leave4.left=leave2;
//        leave3.left=leave1;
//        Boolean result = new SymmetricTree_101().isSymmetricLDR(leave5);
//    }

}
