package contest.contest_18_10_28_108;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/28/18.
 */
public class Binary_Subarrays_With_Sum_930 {
    public int numSubarraysWithSum_force(int[] A, int S) {
        if (S > A.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int temp = 0;
            for (int j = i; j < A.length; j++) {
                temp += A[j];
                if (temp == S){
                    count++;
                } else if (temp > S) {
                    j = A.length;
                }
            }
        }
        return count;
    }

    public int numSubarraysWithSum(int[] A, int S) {
        if (S > A.length) {
            return 0;
        }
        int[] preArray = new int[A.length + 1];
        int sum = 0, result = 0;
        preArray[0] = 1;
        for (int temp : A) {
            sum += temp;
            if (sum - S >= 0) {
                result += preArray[sum - S];
            }
            preArray[sum]++;
        }
        return result;
    }

}
