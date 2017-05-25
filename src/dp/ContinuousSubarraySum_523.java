package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ludao on 2017/4/25.
 */
public class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums==null||nums.length<2){
            return false;
        }
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==0){
                if(nums[i+1]==0){
                    return true;
                }
            }
        }
        k = Math.abs(k);
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            int mod = sum%k;
            if(mod==0&&i>0){
                return true;
            }else {
                Integer tempIndex = map.get(mod);
                if(tempIndex != null) {
                    return true;
                }else {
                    map.put(mod,i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1};
        int k = 0;
        ContinuousSubarraySum_523 continu = new ContinuousSubarraySum_523();
        Boolean result = continu.checkSubarraySum(nums,k);
        return;
    }
}
