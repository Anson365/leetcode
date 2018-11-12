package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/12/18.
 */
public class Longest_Palindromic_Substring_5 {
    private int start;
    private int maxLength = 0;
    public String longestPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            findPalindromicSubStr(s, i, i);
            findPalindromicSubStr(s, i, i + 1);
        }
        return s.substring(start, start + maxLength);
    }

    private void findPalindromicSubStr(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int length = right - left - 1;
        if (maxLength < length) {
            start = left + 1;
            maxLength = length;
        }
    }
}
