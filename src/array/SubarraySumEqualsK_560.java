package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson on 2017/6/4.
 */
public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0,sum=0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int num:nums){
            sum += num;
            if(map.containsKey(sum-k)){
                result+=map.get(sum-k);
            }
            map.put(sum,map.get(sum)==null?0:map.get(sum)+1);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        int k = 3;
        SubarraySumEqualsK_560 subarraySumEqualsK_560 = new SubarraySumEqualsK_560();
        int result = subarraySumEqualsK_560.subarraySum(nums,k);
        System.out.print(true);
    }
}
