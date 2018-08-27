package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 8/27/18.
 */
public class Excel_Sheet_Column_Number_171 {
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            int temp = charArray[i] - 'A' + 1;
            result = (result * 26) + temp;
        }
        return result;
    }
}
