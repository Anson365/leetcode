package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ludao on 2017/7/14.
 */
public class Sum4_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null||nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        if(nums[0]*4>target||max*4<target){
            return result;
        }
        for(int i=0;i<nums.length-3;i++){
            if((i>0&&nums[i-1]==nums[i])||(nums[i]+3*max<target)){
                continue;
            }else if(nums[i]*4>target){
                break;
            }else if(nums[i]*4==target&&i+3<nums.length&&nums[i+3]==nums[i]){
                result.add(Arrays.asList(nums[i],nums[i],nums[i],nums[i]));
            }else {
                threeSum(nums, target - nums[i], i + 1, result, nums[i]);
            }
        }
        return result;
    }


    private void threeSum(int[] nums,int target,int index,List<List<Integer>> result,Integer pre){
        if(nums[index]*3>target){
            return;
        }
        for(int i=index;i<nums.length-2;i++){
            if(target>2*nums[nums.length-1]+nums[i]||(i!=index&&nums[i]==nums[i-1])){
                continue;
            }else if(nums[i]*3>target){
                break;
            }else if(nums[i]*3==target&&i+2<nums.length&&nums[i+2]==nums[i]){
                result.add(Arrays.asList(pre,nums[i],nums[i],nums[i]));
            }else {
                twoSum(nums, target - nums[i], i + 1, result, pre, nums[i]);
            }
        }
    }


    private void twoSum(int[] nums,int target,int index,List<List<Integer>> result,Integer ppre,Integer pre){
        if(nums[index]*2>target){
            return;
        }
        for(int i=index;i<nums.length-1;i++){
            if(target>nums[nums.length-1]+nums[i]||(i!=index&&nums[i]==nums[i-1])){
                continue;
            }else if(nums[i]*2>target){
                break;
            }else if(nums[i]*2==target&&i+1<nums.length&&nums[i+1]==nums[i]){
                result.add(Arrays.asList(ppre,pre,nums[i],nums[i]));
            }else {
                oneSum(nums, target - nums[i], i + 1, result, ppre, pre, nums[i]);
            }
        }
    }

    private void oneSum(int[] nums,int target,int index,List<List<Integer>> result,
                        Integer pppre,Integer ppre,Integer pre){
        if(nums[index]>target){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(target>nums[nums.length-1]+nums[i]||(i!=index&&nums[i]==nums[i-1])){
                continue;
            }if(nums[i]>target){
                break;
            }else if(nums[i]==target){
                result.add(Arrays.asList(pppre,ppre,pre,nums[i]));
            }
        }
    }

//    public static void main(String[] args){
//        Sum4_18 sum4_18 = new Sum4_18();
//        int[] temp = {1, 0, -1, 0, -2, 2};
//        int target = 0;
//        sum4_18.fourSum(temp,target);
//    }
}
