package contest.contest_152;

/**
 * @author luodaihua
 * Created on 2019-09-01
 */
class Contest2 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < calories.length; i = i + k) {
            int temp = 0;
            for (int j = 0; j < k && i + j < calories.length; j++) {
                temp += calories[i + j];
            }
            if (temp < lower) {
                res--;
            } else if (temp > upper) {
                res++;
            }
        }
        return res;
    }
}
