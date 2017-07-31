package hashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/7/31.
 */
public class BrickWall_554 {
    public int leastBricks(List<List<Integer>> wall) {
        int result = 0;
        if(wall==null||wall.size()==0){
            return result;
        }
        int maxEdge = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(List<Integer> list:wall){
            int temp = 0;
            for(int i=0;i<list.size()-1;i++){
                temp +=list.get(i);
                int tempCount = map.getOrDefault(temp,0)+1;
                maxEdge = Math.max(maxEdge,tempCount);
                map.put(temp,tempCount);
            }
        }
        return wall.size()-maxEdge;
    }
}
