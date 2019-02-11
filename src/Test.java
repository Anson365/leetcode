import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ludao on 2017/3/16.
 */
public class Test {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        dfs(root, new ArrayList<Integer>(), list, target);
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return list;
    }

    private void dfs(TreeNode root, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> list, int target) {
        if (root == null) {
            return;
        }
        if (target == 0) {
            list.add(cur);
            return;
        }
        cur.add(root.val);
        dfs(root.left, new ArrayList<>(cur), list, target - root.val);
        dfs(root.right, new ArrayList<>(cur), list, target - root.val);
    }

    public static void main(String[] args) {
        System.out.println(doSomething());
    }

    private static String doSomething() {
        System.out.println("beigin");
        Thread.currentThread().interrupt();
        return "test";
    }

    //    public static void main(String[] args) {
//        Test test = new Test();
//        TreeNode root = new TreeNode(10);
//
//        root.right = new TreeNode(12);
//
//        TreeNode left = new TreeNode(5);
//        left.left = new TreeNode(4);
//        left.right = new TreeNode(7);
//        root.left = left;
//
//        test.FindPath(root, 22);
//    }
}
