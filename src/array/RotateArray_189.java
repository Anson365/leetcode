package array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ludao on 2017/6/7.
 */
public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int num:nums){
            stringBuilder.append(num).append(",");
        }
        StringBuilder temp = stringBuilder.reverse();
        int index = 0;
        for(int i=0;i<k;i++){
            index = temp.indexOf(",",index);
        }
        String tempStr = temp.substring(index)+temp.substring(0, index);
        String[] strArray = new StringBuilder(tempStr).reverse().toString().split(",");
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(strArray[i]);
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 2;
        RotateArray_189 rotateArray_189 = new RotateArray_189();
        rotateArray_189.rotate(nums,k);
    }
}
