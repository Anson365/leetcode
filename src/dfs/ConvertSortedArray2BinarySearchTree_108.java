package dfs;

import BaseConstruction.TreeNode;

/**
 * Created by ludao on 2017/4/22.
 */
public class ConvertSortedArray2BinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if(length==0){
            return null;
        }
        TreeNode root = dfs(0,length-1,nums);
        return root;
    }
    private TreeNode dfs(int start,int end,int[] nums){
        if(start>end){
            return null;
        }

        int temp = start + (end-start)/2;
        TreeNode leafRoot = new TreeNode(nums[temp]);
        leafRoot.left = dfs(start,temp-1,nums);
        leafRoot.right = dfs(temp+1,end,nums);
        return leafRoot;
    }

//    public static void main(String[] args){
//        ConvertSortedArray2BinarySearchTree_108 convertSortedArray2BinarySearchTree_108
//                = new ConvertSortedArray2BinarySearchTree_108();
//        int[] nums = {1,2,3,4};
//        convertSortedArray2BinarySearchTree_108.sortedArrayToBST(nums);
//    }
}
