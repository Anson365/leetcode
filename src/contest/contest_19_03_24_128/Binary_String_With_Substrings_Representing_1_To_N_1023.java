package contest.contest_19_03_24_128;

/**
 * @author luodaihua
 * Created on 2019-03-24
 */
public class Binary_String_With_Substrings_Representing_1_To_N_1023 {
    public boolean queryString(String S, int N) {
        while (N >= 1) {
            if (S.indexOf(Integer.toBinaryString(N)) > -1) {
                N --;
            } else {
                return false;
            }
        }
        return true;
    }
}
