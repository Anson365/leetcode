package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ludao on 2017/6/9.
 */
public class ArrayNesting_565 {
    public int arrayNesting(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(i)){
                continue;
            }
            int temp = nums[i];
            set.add(i);
            int tempLength = 1;
            while(temp != i){
                temp = nums[temp];
                tempLength++;
                set.add(temp);
            }
            max = Math.max(tempLength,max);
        }
        return max;
    }
}
