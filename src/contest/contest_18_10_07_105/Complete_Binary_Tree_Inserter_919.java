package contest.contest_18_10_07_105;

import BaseConstruction.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/7/18.
 */
public class Complete_Binary_Tree_Inserter_919 {
    private TreeNode root ;
    public Complete_Binary_Tree_Inserter_919(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        TreeNode pointer = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pointer);
        return backTracing(queue, v);
    }

    private int backTracing (Queue<TreeNode> treeNodes, int v) {
        TreeNode treeNode = treeNodes.poll();
        if (treeNode.left == null) {
            treeNode.left = new TreeNode(v);
            return treeNode.val;
        } else if (treeNode.right == null) {
            treeNode.right = new TreeNode(v);
            return treeNode.val;
        } else {
            treeNodes.add(treeNode.left);
            treeNodes.add(treeNode.right);
            return backTracing(treeNodes, v);
        }
    }

    public TreeNode get_root() {
        return root;
    }
}
