package hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ludao on 2017/6/12.
 */
public class DistributeCandies_575 {
    public int distributeCandies(int[] candies) {
        if(candies==null||candies.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        int maxSize = candies.length/2;
        for(int i:candies){
            set.add(i);
        }
        return Math.min(maxSize,set.size());
    }
}
