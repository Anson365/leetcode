package tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/6/28.
 */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        helper(root,sum,temp,list);
        return list;
    }

    public void helper(TreeNode root,int sum,List<Integer> temp,List<List<Integer>> list){
        if(root==null){
            return;
        }
        temp.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){
            list.add(new ArrayList<Integer>(temp));
        }
        helper(root.left,sum-root.val,temp,list);
        helper(root.right,sum-root.val,temp,list);
        temp.remove(list.size()-1);
    }
}

