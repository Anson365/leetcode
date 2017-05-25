package bfs;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/4/10.
 */
public class BinaryTreeLevelOrderTraversalII_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        bfs(root,list,0);
        return list;
    }

    private void bfs(TreeNode leaf,List<List<Integer>> leaves,int level){
        if(leaf==null){
            return;
        }
        if(level>leaves.size()-1){//递归到下一层
            leaves.add(0,new ArrayList<Integer>());
        }

        List<Integer> currentLevel = leaves.get(leaves.size()-level-1);
        currentLevel.add(leaf.val);
        bfs(leaf.left, leaves, level+1);
        bfs(leaf.right,leaves,level+1);
    }

}
