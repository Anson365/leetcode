package contest.contest_19_03_31_130;

/**
 * @author luodaihua
 * Created on 2019-03-31
 */
public class Convert_To_Base_N_2_1028 {

    public String baseNeg2(int N) {
        if (N < 2) {
            return Integer.toString(N);
        }
        return baseNeg2(-(N >> 1)) + Integer.toString( N & 1);
    }
}
