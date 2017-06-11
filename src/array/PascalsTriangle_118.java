package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/6/10.
 */
public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows<1){
            return list;
        }
        List<Integer> startList = new ArrayList<Integer>();
        startList.add(1);
        list.add(startList);
        for(int i=1;i<numRows;i++){
            List<Integer> rowList = new ArrayList<Integer>();
            List<Integer> preList = list.get(list.size()-1);
            for(int j=0;j<numRows;j++) {
                if (j == 0 || j == numRows - 1) {
                    rowList.add(1);
                }else {
                    rowList.add(preList.get(j-1)+preList.get(j));
                }
            }
            list.add(rowList);
        }
        return list;
    }
}
