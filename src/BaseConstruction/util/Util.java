package BaseConstruction.util;

import java.util.LinkedList;
import java.util.Queue;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-06-09
 */
public class Util {

    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length < 1) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        int index = 1;
        while (index < array.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                Integer left = array[index++];
                Integer right = array[index++];
                TreeNode leftNode = left == null ? null : new TreeNode(left);
                TreeNode rightNode = right == null ? null : new TreeNode(right);
                tmp.left = leftNode;
                tmp.right = rightNode;
                if (leftNode != null) {
                    queue.add(leftNode);
                }
                if (rightNode != null) {
                    queue.add(rightNode);
                }
            }
        }
        return root;
    }
}
