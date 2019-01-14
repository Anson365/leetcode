package interview.toutiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/14/18.
 */
public class TreeString {

    public String printStr (TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            if ("+".equals(temp) || "-".equals(temp) && i + 2 < list.size()) {
                String tempStr = list.get(i + 2);
                if ("*".equals(tempStr) || "/".equals(tempStr)) {
                    result = result.substring(0,result.length() - 1) + "(" + result.substring(result.length() - 1) + temp + list.get(i + 1) + ")";
                    i++;
                    continue;
                }
            }
            result += temp;
        }
        System.out.println(result);
        return result;
    }

    public void helper(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode("+");
//        TreeNode left = new TreeNode("a");
//        TreeNode rightRoot = new TreeNode("/");
//        TreeNode rootLeft = new TreeNode("-");
//        TreeNode rootRight = new TreeNode("d");
//        TreeNode leftChild = new TreeNode("b");
//        TreeNode rightChild = new TreeNode("c");
//
//        root.left = left;
//        root.right = rightRoot;
//        rightRoot.left = rootLeft;
//        rightRoot.right = rootRight;
//        rootLeft.left = leftChild;
//        rootLeft.right = rightChild;
//
//        TreeString treeString = new TreeString();
//        treeString.printStr(root);
//    }



    static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(String val){
            this.val = val;
        }
    }
}
