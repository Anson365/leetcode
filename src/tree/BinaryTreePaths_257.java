package tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/6/28.
 */
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root==null){
            return list;
        }
        helper(root,"",list);
        return list;
    }

    private void helper(TreeNode treeNode,String split,List<String> list){
        if(treeNode.left==null&&treeNode.right==null){
            list.add((split+"->"+treeNode.val).substring(2));
            return;
        }
        if(treeNode.left!=null){
            helper(treeNode.left,split+"->"+treeNode.val,list);
        }
        if(treeNode.right!=null){
            helper(treeNode.right,split+"->"+treeNode.val,list);
        }
    }
}
