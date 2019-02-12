package divideAndConquer;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author luodaihua
 * Created on 2019-02-12
 */
public class Count_of_Smaller_Numbers_After_Self_315 {
    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, int[]> treeMap = new TreeMap<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            Integer temp = treeMap.floorKey(num);
            if (temp == null) {
                treeMap.put(num, new int[]{0, i});
                result.addFirst(0);
            } else{
                int count = helper(treeMap.get(temp), nums, i);
                result.addFirst(count);
                if (num != temp) {
                    treeMap.put(num, new int[]{count, i});
                }
            }
        }
        return result;
    }

    private int helper(int[] tempArray, int[] nums, int index) {
        int preCount = tempArray[0] ,tempIndex = tempArray[1];
        int count = 0;
        for (int i = index + 1; i <= tempIndex; i++) {
            if (nums[index] > nums[i]) {
                count++;
            }
        }
        return count + preCount;
    }

    public static void main(String[] args) {
        Count_of_Smaller_Numbers_After_Self_315 count = new
                Count_of_Smaller_Numbers_After_Self_315();
        count.countSmaller(new int[] {5,2,2});
    }
}
