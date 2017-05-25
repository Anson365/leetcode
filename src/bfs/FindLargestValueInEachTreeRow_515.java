package bfs;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/4/17.
 */
public class FindLargestValueInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        findLargestValue(root,0,result);
        return result;
    }

    private void findLargestValue(TreeNode leaf,Integer level,List<Integer> list){
        if(leaf==null){
            return;
        }
        if(level>=list.size()){
            list.add(leaf.val);
        }else {
            if(list.get(level)<leaf.val){
                list.set(level,leaf.val);
            }
        }
        findLargestValue(leaf.left,level+1,list);
        findLargestValue(leaf.right,level+1,list);
    }
}
