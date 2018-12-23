package array;

/**
 * Created by ludao on 2017/7/7.
 */
public class SearchInRotatedSortedArrayII_81 {
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return false;
        return binarySearch(nums,target,0,nums.length-1);
    }


    private Boolean binarySearch(int[] nums,int target,int startIndex,int endIndex){
        if(startIndex>endIndex) return false;
        int start = nums[startIndex];
        int end = nums[endIndex];
        int middleIndex = (endIndex-startIndex)/2+startIndex;
        int middle = nums[middleIndex];
        if(middle==target) return true;
        if(middle>=end||middle<=start){//切到中间了  说明两端都有可能存在目标
            return binarySearch(nums,target,startIndex,middleIndex-1)
                    ||binarySearch(nums,target,middleIndex+1,endIndex);
        }
        //其他则按照正常的二分查找进行
        if(target<middle)
            return binarySearch(nums,target,startIndex,middleIndex-1);
        else
            return binarySearch(nums,target,middleIndex+1,endIndex);
    }

//    public static void main(String[] args){
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 5;
//        SearchInRotatedSortedArrayII_81 searchInRotatedSortedArrayII_81
//                = new SearchInRotatedSortedArrayII_81();
//        Boolean result = searchInRotatedSortedArrayII_81.search(nums,5);
//        return;
//
//    }
}
