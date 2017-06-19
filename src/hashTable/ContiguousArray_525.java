package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ludao on 2017/6/17.
 */
public class ContiguousArray_525 {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        if(nums==null||nums.length==0){
            return maxLength;
        }
        int length = nums.length;
        maxLength = 1;
        int[] diff = new int[length+1];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,0);
        for (int i = 1; i <= length; i++) {
            diff[i] = diff[i - 1] + (nums[i - 1] == 0 ? -1 : 1);

            if (!map.containsKey(diff[i]))
                map.put(diff[i], i);
            else
                maxLength = Math.max(maxLength, i - map.get(diff[i]));
        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,1,0};
        ContiguousArray_525 contiguousArray_525 = new ContiguousArray_525();
        int length = contiguousArray_525.findMaxLength(nums);
        return;
    }
}
