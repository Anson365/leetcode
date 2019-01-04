package math;

/**
 * Created by Anson on 1/4/19.
 */
public class Super_Palindromes_906 {

    private int result = 0;
    public int superpalindromesInRange(String L, String R) {
        long l = Long.valueOf(L);
        long r = Long.valueOf(R);
        dfs("", l, r);
        for (int i = 0; i < 10; i++) {
            dfs("" + i, l, r);
        }
        return result;
    }

    private void dfs(String s, long l, long r) {
        if (s.length() > 9) {
            return;
        }

        if (s.length() > 0 && s.charAt(0) != 0) {
            long num = Long.valueOf(s);
            num *= num;

            if (num > r) {
                return;
            }
            if (num >= l && isPalindrome("" + num)) {
                result ++;
            }
        }
        for (int i = 0; i < 10; i++) {
            String next = "" + i + s + i;
            dfs(next, l, r);
         }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
