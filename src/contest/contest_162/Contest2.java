package contest.contest_162;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anson
 * Created on 2019-11-10
 */
class Contest2 {


    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> tempIndex = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();
        int tempSum = 0;
        for (int i = 0; i < colsum.length; i++) {
            int temp = colsum[i];
            if (temp == 0) {
                upperList.add(0);
                lowerList.add(0);
            } else if (temp == 2) {
                upperList.add(1);
                lowerList.add(1);
                tempSum++;
            } else {
                tempIndex.add(i);
                upperList.add(0);
                lowerList.add(0);
            }
        }
        if (tempSum > lower || tempSum > upper) {
            return new ArrayList<>();
        }
        lower -= tempSum;
        upper -= tempSum;
        for(int i = 0; i < tempIndex.size(); i++) {
            if (lower == 0) {
                upper--;
                upperList.set(tempIndex.get(i), 1);
            } else {
                lower--;
                lowerList.set(tempIndex.get(i), 1);
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(upperList);
        resList.add(lowerList);
        return resList;
    }

}
