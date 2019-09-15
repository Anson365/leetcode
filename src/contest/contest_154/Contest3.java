package contest.contest_154;

/**
 * @author luodaihua
 * Created on 2019-09-15
 */
public class Contest3 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if (k <= 3) {
            return findKMaxInArray(arr, k);
        }
        int temp1 = findKMaxInArray(arr, 1);
        int temp2 = findKMaxInArray(arr, 2);
        if (temp1 > temp2 || temp1 == 0) {
            return temp1;
        }
        int temp3 = findKMaxInArray(arr, 3);
        if (temp2 >= temp3) {
            return temp2;
        }
        int res = temp1;
        int diff = temp2 - temp1;
        for (int i = 1; i < k; i++) {
            res += diff;
            res %= (int)1e9 + 7;
        }
        return res;
    }


    private int findKMaxInArray(int [] array, int k) {
        int temp = 0;
        int max = 0;
        for (int j = 0; j < k; j ++) {
            for (int i : array) {
                temp += i;
                if (temp < 0) {
                    temp = 0;
                } else {
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }
}
