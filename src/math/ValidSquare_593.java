package math;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ludao on 2017/6/27.
 */
public class ValidSquare_593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(dis(p1,p2));
        set.add(dis(p1,p3));
        set.add(dis(p2,p3));
        set.add(dis(p1,p4));
        set.add(dis(p2,p4));
        set.add(dis(p3,p4));
        return !set.contains(0)&&set.size()==2;
    }

    private int dis(int[] source,int[] target){
        return (source[0]-target[0])*(source[0]-target[0]) + (source[1]-target[1])*(source[1]-target[1]);
    }
}
