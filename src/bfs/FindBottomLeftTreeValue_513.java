package bfs;

import BaseConstruction.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ludao on 2017/4/13.
 */
public class FindBottomLeftTreeValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer,TreeNode> map = new HashMap<Integer, TreeNode>();
        map.put(0, root);
        findBottomLeftValue(root, 0, map);
        TreeNode leftBottomLeftNode = map.get(map.size()-1);
        return leftBottomLeftNode.val;
    }

    public void findBottomLeftValue(TreeNode leaf,int level,Map<Integer,TreeNode> map){
        if(leaf==null){
            return;
        }
        if(leaf!=null){//only save left value
            TreeNode leftMost = map.get(level);
            if(leftMost==null) {
                map.put(level, leaf);
            }
        }
        findBottomLeftValue(leaf.left,level+1,map);
        findBottomLeftValue(leaf.right,level+1,map);
    }
}
