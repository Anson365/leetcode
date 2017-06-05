package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Anson on 2017/6/5.
 */
public class KdiffPairsinanArray_532 {
    public int findPairs(int[] nums, int k) {
        if(nums==null||nums.length==0||k<0) return 0;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> set = map.keySet();
        for(Integer key:set){
            if(k==0){
                if(map.get(key)>1){
                    result++;
                }
            }else {
                if(map.containsKey(key+k)){
                    result++;
                }
            }
        }
        return result;
    }
}
