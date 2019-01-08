package tree;

import BaseConstruction.TreeNode;

/**
 * Created by Anson on 1/7/19.
 */
public class Binary_Tree_Cameras_968 {

    private final int NOT_MONITORED = 0;
    private final int MONITORED_WITHOUT_CAMERAS = 1;
    private final int MONITORED_WITH_CAMERAS = 2;

    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return cameras;
        }
        int temp = dfs(root);
        return cameras + temp == NOT_MONITORED ? 1 : 0;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return MONITORED_WITHOUT_CAMERAS;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == MONITORED_WITHOUT_CAMERAS && right == MONITORED_WITHOUT_CAMERAS) {
            return NOT_MONITORED;
        }
        if (left == NOT_MONITORED || right == NOT_MONITORED) {
            cameras++;
            return MONITORED_WITH_CAMERAS;
        }
        return MONITORED_WITHOUT_CAMERAS;
    }
}
