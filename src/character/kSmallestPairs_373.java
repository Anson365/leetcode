package character;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/3/3.
 * 思路：因为数组有序，因此可循环排序直接取出需要返回的数量
 */
public class kSmallestPairs_373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        int length = nums1.length * nums2.length;
        int indexMax = length>k?k:length;
        int nums1Index=0,nums2Index=0;
        for(int i=0;i<indexMax;i++){
            int num1 = nums1[nums1Index];
            int num2 = nums2[nums2Index];
            int[] ele = new int[]{num1,num2};
            result.add(ele);
            int compare1 = indexCompare(nums1,nums1Index);
            int compare2 = indexCompare(nums2,nums2Index);
            if(compare1>compare2){//防止步进过长 漏掉数据
                nums2Index++;
            }else if(compare1==compare2){
                if(nums1Index>nums2Index){
                    nums2Index++;
                }else {
                    nums1Index++;
                }
            }else {
                nums1Index++;
            }
        }
        return result;
    }

    private int indexCompare(int[] num,int index){
        if(index+1>=num.length){
            return Integer.MAX_VALUE;
        }else {
            return num[index+1] - num[index];
        }
    }

//    public static void main(String[] args){
//        int[] nums1 = {1,1,2};
//        int[] nums2 = {1,2,3};
//        kSmallestPairs_373 kSmallestPairs_373 = new kSmallestPairs_373();
//        kSmallestPairs_373.kSmallestPairs(nums1,nums2,10);
//    }
}
