package dfs;

import BaseConstruction.TreeNode;

/**
 * Created by ludao on 2017/4/19.
 */
public class FlattenBinaryTreeToLinkedList_114 {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = null;
        while(root.right!=null){
            root = root.right;
        }
        root.right = right;
    }




//    public static void main(String[] args){
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        treeNode3.right = treeNode6;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//
//        FlattenBinaryTreeToLinkedList_114 flattenBinaryTreeToLinkedList_114 = new FlattenBinaryTreeToLinkedList_114();
//        flattenBinaryTreeToLinkedList_114.flatten(treeNode1);
//        System.out.print(treeNode1);
//    }
}
