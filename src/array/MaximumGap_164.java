package array;

import java.util.Arrays;

/**
 * Created by Anson on 2017/5/28.
 * timespace O(nlgn)
 */
public class MaximumGap_164 {

    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<=1){
            return 0;
        }
        Arrays.sort(nums);
        int temp = 0;
        for(int i=1;i<nums.length;i++){
            int gap = nums[i]-nums[i-1];
            temp = temp>gap?temp:gap;
        }
        return temp;
    }
}
