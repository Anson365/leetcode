package contest.contest_150;

import java.util.LinkedList;
import java.util.Queue;

import BaseConstruction.TreeNode;
import BaseConstruction.util.Util;

/**
 * @author luodaihua
 * Created on 2019-08-18
 */
class Contest2 {
    private int maxLevel = 0;
    private int max = Integer.MIN_VALUE;
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        helper(queue, 1);
        return maxLevel;
    }

    private void helper(Queue<TreeNode> queue, int level) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmp = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                tmp += tmpNode.val;
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }
            if (tmp > max) {
                max = tmp;
                maxLevel = level;
            }
            level++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(989);
        TreeNode level2Right = new TreeNode(10250);
        TreeNode level3left = new TreeNode(98693);
        TreeNode level3Right = new TreeNode(-89388);
        TreeNode level4Right = new TreeNode(-32127);
        root.right = level2Right;
        level2Right.left = level3left;
        level2Right.right = level3Right;
        level3Right.right = level4Right;


        new Contest2().maxLevelSum(root);
    }
}
