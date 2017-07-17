package twopointer;

/**
 * Created by ludao on 2017/7/17.
 */
public class Search4Range_34 {

    private int first = -1;
    private int last = -1;
    public int[] searchRange(int[] nums, int target) {
        findFirst(nums,target);
        int start = first==-1?0:first;
        findLast(nums,target,start);
        return new int[]{first,last};
    }

    private void findFirst(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        while (start<=end){
            int middle = (end-start)/2 + start;
            if(nums[middle]>target){
                end = middle - 1;
            }else if(nums[middle]<target){
                start = middle + 1;
            }else {
                end = middle-1;
                index = middle;
            }
        }
        first = index;
    }

    private void findLast(int[] nums,int target,int start){
        int end = nums.length - 1;
        int index = -1;
        while (start<=end){
            int middle = (end-start)/2 + start;
            if(nums[middle]>target){
                end = middle - 1;
            }else if(nums[middle]<target){
                start = middle + 1;
            }else {
                start = middle+1;
                index = middle;
            }
        }
        last = index;
    }

    public static void main(String[] args){
        int[] array = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Search4Range_34 search4Range_34 = new Search4Range_34();
        search4Range_34.findFirst(array, target);
        int start = search4Range_34.first;
        search4Range_34.findLast(array,target,start);
        int end = search4Range_34.last;
        System.out.print(end);
    }


}
