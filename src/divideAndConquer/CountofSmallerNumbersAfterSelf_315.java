package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ludao on 2017/5/5.
 */
public class CountofSmallerNumbersAfterSelf_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null||nums.length==0){
            return result;
        }
        int length = nums.length;
        List<Integer> sorted = new ArrayList<Integer>();
        Integer[] dp = new Integer[length];
        for(int i=length-1;i>=0;i--){
            int temp = nums[i];
            int index = binarySearch(sorted,temp);
            sorted.add(index,temp);
            dp[i] = index;
        }
        result = Arrays.asList(dp);
        return result;
    }

    private int binarySearch(List<Integer> sorted,int target){
        if(sorted.size()==0){
            return 0;
        }
        int start = 0,end=sorted.size()-1;
        if(sorted.get(start)>=target) return start;
        if(sorted.get(end)<target) return end+1;
        while (start+1<end){
            int mid = (end-start)/2 + start;
            int temp = sorted.get(mid);
            if(target==temp){
                return mid;
            }
            if(target>temp){
                start = mid + 1;
            }
            if(target<temp){
                end = mid - 1;
            }
        }
        if (sorted.get(start) >= target) return start;
        return end;
    }


//    public static void main(String[] args){
//        int[] nums = {2,1,1,1,2,15,3,3,15,0};
//        CountofSmallerNumbersAfterSelf_315 c = new CountofSmallerNumbersAfterSelf_315();
//        List<Integer> result = c.countSmaller(nums);
//        return;
//    }
}
