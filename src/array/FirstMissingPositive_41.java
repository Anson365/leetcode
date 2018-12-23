package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ludao on 2017/6/11.
 */
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0){
            return 1;
        }
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            if(temp>0&&temp<=nums.length){
                if(i!=temp-1&&nums[i]!=nums[temp-1]) {
                    int val = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1] = val;
                    i--;
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;
    }
//    public static void main(String[] args){
//        int[] array = {1,3,4,-1};
//        FirstMissingPositive_41 firstMissingPositive_41 = new FirstMissingPositive_41();
//        int result = firstMissingPositive_41.firstMissingPositive(array);
//        System.out.print(true);
//    }
}
