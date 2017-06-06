package array;

/**
 * Created by Anson on 2017/6/6.
 */
public class ShortestUnsortedContinuousSubarray_581 {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length,start = 0,end = -1,max=nums[0],min=nums[length-1];
        for(int i=1;i<length;i++){
            if(max<=nums[i]){
                max = nums[i];
            }else {
                end = i;
            }
            if(min>=nums[length-i-1]){
                min = nums[length-i-1];
            }else {
                start = length-i-1;
            }
        }
        return end-start+1;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        ShortestUnsortedContinuousSubarray_581 shortestUnsortedContinuousSubarray_581
                = new ShortestUnsortedContinuousSubarray_581();
        int result = shortestUnsortedContinuousSubarray_581.findUnsortedSubarray(nums);
        System.out.print(true);
    }
}
