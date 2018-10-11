package array;

import java.util.TreeSet;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/11/18.
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE, row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < column; i++) {
            int[] temp = new int[row];
            for (int j = i; j < column; j++) {
                int tempMax = Integer.MIN_VALUE, tempSum = 0;
                for (int m = 0; m < temp.length; m++) {
                    temp[m] += matrix[m][j];
                }
                max = Math.max(max, findMax(temp, k));
            }

        }
        return max;
    }

    private int findMax(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);

        for(int i = 0;i < nums.length; i ++){
            sum += nums[i];
            Integer gap = s.ceiling(sum - k);
            if(gap != null) max = Math.max(max, sum - gap);
            s.add(new Integer(sum));
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] array = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        Max_Sum_of_Rectangle_No_Larger_Than_K_363 max_sum_of_rectangle_no_larger_than_k_363 = new Max_Sum_of_Rectangle_No_Larger_Than_K_363();
//        max_sum_of_rectangle_no_larger_than_k_363.maxSumSubmatrix(array, 8);


        int[] temp = {5, 6, 3};
        max_sum_of_rectangle_no_larger_than_k_363.findMax(temp, 4);
    }
}
