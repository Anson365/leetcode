package math;

/**
 * Created by Anson on 1/17/19.
 */
public class Equal_Rational_Numbers_972 {
    public boolean isRationalEqual(String S, String T) {
        return helper(S) == helper(T);
    }


    private double helper(String s) {
        int index = s.indexOf("(") ;
        if (s.indexOf("(") == -1) {
            return Double.valueOf(s);
        }
        String nonRepeatPart = s.substring(0, index);
        String repeatPart = s.substring(index + 1, s.length() - 1);
        for (int i = 0; i < 5; i++) {
            repeatPart += repeatPart;
        }
        return Double.valueOf((nonRepeatPart + repeatPart).substring(0, 20));
    }
}
