package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/8/18.
 */
public class Binary_Subarrays_With_Sum_930 {
    public int numSubarraysWithSum(int[] A, int S) {
        if(S > A.length) {
            return 0;
        }
        int[] array = new int[A.length + 1];
        array[0] = 1;
        int countOne = 0, result = 0;
        for (int temp : A) {
            countOne += temp;
            if (countOne >= S) {
                result += array[countOne - S];
            }
            array[countOne]++;
        }
        return result;
    }

    public static void main(String[] args) {
        Binary_Subarrays_With_Sum_930 binary_subarrays_with_sum_930 = new Binary_Subarrays_With_Sum_930();
        binary_subarrays_with_sum_930.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2);
    }
}
