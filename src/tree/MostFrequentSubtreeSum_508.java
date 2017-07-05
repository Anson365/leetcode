package tree;

import BaseConstruction.TreeNode;

import java.util.*;

/**
 * Created by ludao on 2017/7/5.
 */
public class MostFrequentSubtreeSum_508 {
    private int maxFrequent = 1;
    private Map<Integer,Integer> map = new HashMap<Integer, Integer>();

    public int[] findFrequentTreeSum(TreeNode root) {
        LRD(root);
        if(map.size()==0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<Integer>();
        for(Integer key:map.keySet()){
            Integer value = map.get(key);
            if(value==maxFrequent){
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    private int LRD(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum = LRD(root.left);
        int rightSum = LRD(root.right);
        int currentSum = root.val + leftSum + rightSum;
        if(map.containsKey(currentSum)){
            Integer frequent = map.get(currentSum);
            map.put(currentSum,frequent+1);
            maxFrequent = Math.max(frequent+1,maxFrequent);
        }else {
            map.put(currentSum,1);
        }
        return root.val + leftSum + rightSum;
    }
}
