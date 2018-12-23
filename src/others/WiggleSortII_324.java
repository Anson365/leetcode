package others;

import java.util.Arrays;

/**
 * Created by ludao on 2017/4/6.
 */
public class WiggleSortII_324 {
    public void wiggleSort(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int[] tempNums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(tempNums);
        int length = nums.length;
        if(length%2==0){
            int tempLength = length/2;
            for(int i=0;i<tempLength;i++){
                nums[2*i] = tempNums[tempLength-i-1];
                nums[2*i+1] = tempNums[length-i-1];
            }
        }else {
            int tempLength = length/2;
            for(int i=0;i<tempLength;i++){
                nums[2*i] = tempNums[tempLength-i];
                nums[2*i+1] = tempNums[length-i-1];
            }
            nums[2*tempLength] = tempNums[0];
        }
    }

//    public static void main(String[] args){
//        int[] nums = {1,5,1,1,6,4};
//        WiggleSortII_324 wiggleSortII_324 = new WiggleSortII_324();
//
//        wiggleSortII_324.wiggleSort(nums);
//    }
}
