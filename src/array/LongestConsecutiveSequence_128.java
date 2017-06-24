package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ludao on 2017/6/24.
 */
public class LongestConsecutiveSequence_128 {
        public int longestConsecutive(int[] nums) {
            int result = 0;
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int temp:nums){
                if(map.containsKey(temp)){
                    continue;
                }
                Integer left = map.get(temp-1);
                Integer right = map.get(temp+1);
                left = left==null?0:left;
                right = right==null?0:right;
                int sum = left+right+1;
                map.put(temp,sum);
                map.put(temp-left,sum);
                map.put(temp+right,sum);
                result = Math.max(result,sum);
            }
            return result;
        }


}
