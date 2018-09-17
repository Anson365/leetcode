package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/16/18.
 */
public class Sort_Array_By_Parity_905 {
    public int[] sortArrayByParity(int[] A) {

        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int temp : A) {
            if (temp % 2 == 0) {
                evenList.add(temp);
            } else {
                oddList.add(temp);
            }
        }
        evenList.addAll(oddList);
        int[] result = new int[evenList.size()];
        for (int i = 0; i < evenList.size(); i++) {
            result[i] = evenList.get(i);
        }
        return result;
    }
}
