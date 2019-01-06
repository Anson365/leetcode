package contest.contest_19_01_06_118;

/**
 * Created by Anson on 1/6/19.
 */
public class Equal_Rational_Numbers_972 {
    public boolean isRationalEqual(String S, String T) {
        return helper(S) == helper(T);
    }

    private double helper(String s) {
        int temp = s.indexOf('(');
        if (temp < 0) {
            return Double.valueOf(s);
        }
        String base = s.substring(0, temp);
        String rep = s.substring(temp + 1, s.length() - 1);
        for (int i = 0; i < 20; i++) {
            base += rep;
        }
        return Double.valueOf(base.substring(0, 20));
    }
}
