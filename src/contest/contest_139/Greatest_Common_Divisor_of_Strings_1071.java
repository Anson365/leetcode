package contest.contest_139;

/**
 * @author luodaihua
 * Created on 2019-06-02
 */
public class Greatest_Common_Divisor_of_Strings_1071 {
    public String gcdOfStrings(String str1, String str2) {
        String s1 = helper(str1);
        String s2 = helper(str2);
        boolean f1 = !"".equals(s1.replaceAll(s2, ""));
        boolean f2 = !"".equals(s2.replaceAll(s1, ""));
        if (f1 && f2) {
            return "";
        }
        String s = !f1 ? s2 : s1;
        int count1 = str1.replaceAll(s, "1").length();
        int count2 = str2.replaceAll(s, "1").length();
        int tmp = getGCD(count1, count2);
        StringBuilder result = new StringBuilder();
        while (tmp > 0) {
            result.append(s);
            tmp--;
        }
        return result.toString();
    }

    private int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }


    private String helper(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            if ("".equals(str.replaceAll(sb.toString(), ""))) {
                return sb.toString();
            }
        }
        return str;
    }
}
