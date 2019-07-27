package contest.contest_bi_5;

/**
 * @author luodaihua
 * Created on 2019-07-27
 */
public class Largest_Unique_Number_1133 {
    public int largestUniqueNumber(int[] A) {
        int[] memo = new int[1001];
        for (int i : A) {
            memo[i]++;
        }
        for (int i = 1000; i >= 0; i--) {
            if (memo[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
