package divideAndConquer;

/**
 * Created by ludao on 2017/5/3.
 */
public class BurstBalloons_312 {
    public int maxCoins(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]*nums[1] + maxCoins(newArray(nums,nums[0]>nums[1]?1:0)) ;
        }
        if(nums.length==3){
            return nums[0]*nums[1]*nums[2] + maxCoins(newArray(nums,1));
        }
        int minIndex = findMin(nums);
        int left = minIndex<1?1:nums[minIndex-1];
        int right = minIndex>=nums.length-1?1:nums[minIndex+1];
        return left*nums[minIndex]*right+maxCoins(newArray(nums,minIndex));
    }


    private int[] newArray(int[] temp,int index){
        int[] newArray = new int[temp.length-1];
        int j = 0;
        for(int i=0;i<temp.length;i++){
            if(i!=index){
                newArray[j] = temp[i];
                j++;
            }
        }
        return newArray;
    }

    private int findMin(int[] nums){
        int temp = nums[0],index=0;
        for(int i=0;i<nums.length;i++){
            if(temp>nums[i]){
                temp = nums[i];
                index = i;
            }
        }
        return index;
    }
}
