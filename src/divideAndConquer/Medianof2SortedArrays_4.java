package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ludao on 2017/5/2.
 */
public class Medianof2SortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1==null||nums1.length==0)
                &&(nums2==null||nums2.length==0)){
            return 0d;
        }
        if(nums1==null||nums1.length==0){
            return findMedianSortedArrays(nums2,nums1);
        }
        if(nums2==null||nums2.length==0){
            int length = nums1.length;
            if(length%2==0){
                return (nums1[length/2-1]+nums1[length/2])/2.0d;
            }else {
                return nums1[length/2]/1.0d;
            }
        }

        int nums1Min = nums1[0],nums1Max = nums1[nums1.length-1];
        int nums2Min = nums2[0],nums2Max = nums2[nums2.length-1];
        if(nums1Min==nums2Min&&nums1Max==nums2Max&&nums1.length<3&&nums1.length==nums2.length){
            return findMedianSortedArrays(nums1,new int[]{});
        }
        if(nums1Min>=nums2Max||nums1Max<=nums2Min){
            return nums1Min>=nums2Max?(nums1Min+nums2Max)/2.0d:(nums1Max+nums2Min)/2.0d;
        }
        int numsMin = nums1Min>nums2Min?nums1Min:nums2Min;
        int numsMax = nums1Max>nums2Max?nums2Max:nums1Max;
        int[] tempNums1 = newArray(nums1,numsMin,numsMax);
        int[] tempNums2 = newArray(nums2,numsMin,numsMax);
        if(tempNums1.length==nums1.length&&tempNums2.length==nums2.length){
            return findMedianSortedArrays(
                    Arrays.copyOfRange(tempNums1,1,tempNums1.length-1),Arrays.copyOfRange(tempNums2,1,tempNums2.length-1));
        }
        return findMedianSortedArrays(tempNums1,tempNums2);
    }

    private int[] newArray(int[] nums,int min,int max){
        List<Integer> tempNumsList = new ArrayList<Integer>();
        for(int num:nums){
            if(num>=min&&num<=max){
                tempNumsList.add(num);
            }
        }
        int[] result = new int[tempNumsList.size()];
        for(int i=0;i<tempNumsList.size();i++){
            result[i] = tempNumsList.get(i);
        }
        return result;
    }

//    public static void main(String[] args){
//        int[] nums1 = {2};
//        int[] nums2 = {1,3};
//        double result = new Medianof2SortedArrays_4().findMedianSortedArrays(nums1,nums2);
//        return;
//    }
}
