package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ludao on 2017/6/14.
 */
public class FindAllDuplicatesInAnArray_442 {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        if(nums==null||nums.length==0){
            return new ArrayList<Integer>(set);
        }
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            if(current-1 != i){
                int target = nums[current-1];
                if(target==current){
                    set.add(target);
                    continue;
                }else {
                    int temp = nums[current-1];
                    nums[current-1] = nums[i];
                    nums[i] = temp;
                    i--;
                }
            }
        }
        return new ArrayList<Integer>(set);
    }

//    public static void main(String[] args){
//        int[] nums = {4,3,2,7,8,2,3,1};
//        FindAllDuplicatesInAnArray_442 findAllDuplicatesInAnArray_442 = new FindAllDuplicatesInAnArray_442();
//        findAllDuplicatesInAnArray_442.findDuplicates(nums);
//    }
}
