package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-03-17
 */
public class Symmetric_Tree_101 {
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        return bfs(list);
    }

    private boolean bfs(List<TreeNode> list) {
         int size = list.size();
         if (list.size() == 0) {
             return true;
         }
         for (int i = 0; i < size / 2; i++) {
             TreeNode left = list.get(i);
             TreeNode right = list.get(size - 1 - i);
             if (left == null && right == null) {
                 continue;
             }
             if (left == null || right == null) {
                 return false;
             }
             if (left.val != right.val) {
                 return false;
             }
         }
         for (int i = 0; i < size; i++) {
             TreeNode temp = list.get(i);
             if (temp != null) {
                 list.add(temp.left);
                 list.add(temp.right);
             }
         }
         return bfs(new ArrayList<>(list.subList(size, list.size())));
    }
}
