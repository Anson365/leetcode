package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-02-25
 */
public class PrintBinaryTree_655 {
    private int height = 0;
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        getHeight(root, 1);
        int size = (int) Math.pow(2, height) - 1;
        //init
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                list.add("");
            }
            result.add(list);
        }
        helper(result, 0, 0, size - 1, root);
        return result;
    }

    private void helper(List<List<String>> result, int height, int start, int end, TreeNode root) {
        if (root == null) {
            return;
        }
        int pos = (start + end) / 2;
        List<String> temp = result.get(height);
        temp.set(pos, String.valueOf(root.val));
        helper(result, height + 1, start, pos - 1, root.left);
        helper(result, height + 1, pos + 1, end, root.right);
    }

    private void getHeight(TreeNode root, int currentHeight) {
        if (root == null) {
            height = Math.max(currentHeight - 1, height);
            return;
        }
        getHeight(root.left, currentHeight + 1);
        getHeight(root.right, currentHeight + 1);
    }
}
