package contest.contest_157;

/**
 * @author luodaihua
 * Created on 2019-10-06
 */
public class Contest1 {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for (int i : chips) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
