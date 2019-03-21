package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BaseConstruction.TreeNode;

/**
 * @author luodaihua
 * Created on 2019-03-21
 */
public class Find_Mode_in_Binary_Search_Tree_501 {

    private List<Integer> modeList = new ArrayList<>();
    private int count = 0;
    private int maxCount = 0;
    private Integer preValue;


    public int[] findMode(TreeNode root) {
        helper(root);
        return modeList.stream().mapToInt(item -> (int)item).toArray();
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        int currentVal = root.val;
        if(preValue != null && preValue == currentVal) {
            count++;
        } else {
            count = 1;
            preValue = currentVal;
        }
        if (maxCount < count) {
            modeList.clear();
            modeList.add(preValue);
            maxCount = count;
        } else if (maxCount == count){
            modeList.add(preValue);
        }
        helper(root.right);
    }
}
