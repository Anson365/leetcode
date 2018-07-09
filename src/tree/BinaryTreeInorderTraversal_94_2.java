package tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 7/9/18.
 */
public class BinaryTreeInorderTraversal_94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doTraversalWithIterative(root, list);
        return list;
    }


    public void doTraversalWithRecursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // left
        doTraversalWithRecursive(root.left, list);
        // middle
        list.add(root.val);
        // right
        doTraversalWithRecursive(root.right, list);
    }

    public void doTraversalWithIterative(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
    }
}
