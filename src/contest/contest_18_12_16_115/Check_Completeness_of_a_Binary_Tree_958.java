package contest.contest_18_12_16_115;

import BaseConstruction.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Anson  on 12/16/18.
 */
public class Check_Completeness_of_a_Binary_Tree_958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();

    }
    public boolean isCompleteTree_II(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                size--;
                if (temp.left != null) {
                    if (flag) {
                        return false;
                    }
                    if(temp.right == null) {
                        flag = true;
                        queue.offer(temp.left);
                    } else {
                        queue.offer(temp.left);
                        queue.offer(temp.right);
                    }
                } else {
                    if (temp.right != null) {
                        return false;
                    }
                    if (!flag) {
                        flag = true;
                    }
                }
            }

        }
        return true;
    }




}
