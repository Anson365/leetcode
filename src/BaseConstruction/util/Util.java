package BaseConstruction.util;

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
        TreeNode root = new TreeNode(array[0]);
        return buildChild(root, 0, array);
    }


    private static TreeNode buildChild(TreeNode root, int index, Integer[] array) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int length = array.length;
        if (left < length) {
            root.left = new TreeNode(array[left]);
            buildChild(root.left, left, array);
        }
        if (right < length) {
            root.right = new TreeNode(array[right]);
            buildChild(root.right, right, array);
        }
        return root;
    }
}
