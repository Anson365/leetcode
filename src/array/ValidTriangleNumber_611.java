package array;

import java.util.Arrays;

public class ValidTriangleNumber_611 {
    public int triangleNumber(int[] nums) {
        int result = 0;
        if(nums==null||nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for(int r=2;r<nums.length;r++){
            int m = r-1,l=0;
            while (l<m){
                if(nums[l]+nums[m]>nums[r]){
                    result+=(m-l);
                    m--;
                }else {
                    l++;
                }
            }
        }
        return result;
    }
}
