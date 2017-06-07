package design.tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Anson on 2017/6/1.
 */
public class BinarySearchTreeIterator_173_2 {

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator_173_2(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        initLDR(root);

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()){
            return 0;
        }
        return stack.pop().val;
    }


    private void initLDR(TreeNode root){
        if(root==null){
            return;
        }
        initLDR(root.right);
        stack.push(root);
        initLDR(root.left);
    }
}
