package dp;

/**
 * Created by ludao on 2017/5/7.
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int length = nums.length;
        if(nums[0]>=target) return 0;
        if(nums[length-1]<target) return length;
        int start=0,end=length-1;
        while (start<end){
            int mid = (end-start)/2 + start;
            int temp = nums[mid];
            if(temp>=target){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        if(nums[start]>=target) return start;
        else  return end;
    }

   public static void main(String[] args){
       int[] nums = {1,3,5,6};
       int target = 2;
       SearchInsertPosition_35 searchInsertPosition_35 = new SearchInsertPosition_35();
       int result = searchInsertPosition_35.searchInsert(nums,target);
       return;
   }
}
