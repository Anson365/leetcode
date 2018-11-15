package divideAndConquer;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/15/18.
 */
public class Unique_Binary_Search_Trees_II_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTree(1, n);
    }

    private List<TreeNode> genTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = genTree(start, i - 1);
            List<TreeNode> right = genTree(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
