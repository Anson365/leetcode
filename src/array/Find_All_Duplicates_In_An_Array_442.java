package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 8/22/18.
 */
public class Find_All_Duplicates_In_An_Array_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        for (int num : nums) {
            if (temp[num] != 0) {
                result.add(num);
            } else {
                temp[num] = num;
            }
        }
        return result;
    }
}
