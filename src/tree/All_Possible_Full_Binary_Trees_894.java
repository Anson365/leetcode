package tree;

import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/18/18.
 */
public class All_Possible_Full_Binary_Trees_894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if (N < 1) {
            return result;
        }else if (N == 1) {
            result.add(new TreeNode(0));
        } else {
            for (int i = 1; i <= (N - 1) / 2; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - 1 - i);
                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode : right) {
                        TreeNode root1 = new TreeNode(0);
                        root1.left = leftNode;
                        root1.right = rightNode;
                        result.add(root1);
                        if (i != (N - 1) / 2) {
                            TreeNode root2 = new TreeNode(0);
                            root2.left = rightNode;
                            root2.right = leftNode;
                            result.add(root2);
                        }
                    }
                }
            }
        }
        return result;
    }
}
