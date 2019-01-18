package tree;

import BaseConstruction.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anson on 1/18/19.
 */
public class Check_Completeness_of_a_Binary_Tree_958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && queue.peek() != null) {
            int size = queue.size();
            while (size > 0 && queue.peek() != null) {
                TreeNode tempRoot = queue.poll();
                queue.offer(tempRoot.left);
                queue.offer(tempRoot.right);
                size--;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode tempRoot = queue.poll();
            if (tempRoot != null) {
                return false;
            }
        }
        return true;
    }
}
