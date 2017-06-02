package design.tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anson on 2017/6/1.
 */
public class BinarySearchTreeIterator_173 {

    private Iterator<TreeNode> iterator;

    public BinarySearchTreeIterator_173(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        initLDR(root,list);
        iterator = list.iterator();

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next().val;
    }


    private void initLDR(TreeNode root,List<TreeNode> list){
        if(root==null){
            return;
        }
        initLDR(root.right,list);
        list.add(root);
        initLDR(root.left,list);
    }
}
