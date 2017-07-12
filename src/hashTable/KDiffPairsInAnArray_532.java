package hashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ludao on 2017/7/12.
 */
public class KDiffPairsInAnArray_532 {
    public int findPairs(int[] nums, int k) {
        if(nums==null||nums.length==0||k<0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int num:nums){
            if(map.containsKey(num)){
                int temp = map.get(num);
                map.put(num,temp+1);
            }else {
                map.put(num,1);
            }
        }
        Set<Integer> keySet = map.keySet();
        int result = 0;
        if(k==0){
            for(Integer key:keySet){
                if(map.get(key)>1){
                    result++;
                }
            }
        }else {
            for(Integer key:keySet){
                if(keySet.contains(key+k)){
                    result++;
                }
            }
        }
        return result;
    }
}
