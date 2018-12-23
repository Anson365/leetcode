package contest.contest_18_10_07_105;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/7/18.
 */
public class Maximum_Sum_Circular_Subarray_918 {
    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, tempMaxSum = 0, tempMinSum = 0, maxItem = A[0], sum = 0;
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            sum += temp;
            maxItem = Math.max(maxItem, temp);
            tempMaxSum += temp;
            tempMinSum += temp;
            max = Math.max(max, tempMaxSum);
            if (tempMaxSum < 0) {
                tempMaxSum = 0;
            }
            min = Math.min(min, tempMinSum);
            if (tempMinSum > 0) {
                tempMinSum = 0;
            }
        }

        return maxItem < 0 ? maxItem : Math.max(max, sum - min);
    }

//    public static void main(String[] args) {
//        Maximum_Sum_Circular_Subarray_918 maximum_sum_circular_subarray_918 = new Maximum_Sum_Circular_Subarray_918();
//        maximum_sum_circular_subarray_918.maxSubarraySumCircular(new int[]{5, -2, 5});
//    }
}
