package contest.contest_18_10_07_105;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/7/18.
 */
public class Reverse_Only_Letters_917 {
    public String reverseOnlyLetters(String S) {
        int start = 0, end = S.length() - 1;
        char[] chars = S.toCharArray();
        while (end > start) {
            char startChar = chars[start];
            char endChar = chars[end];
            if (isLetter(startChar) && isLetter(endChar)) {
                swap(chars, start, end);
                start++;
                end--;
            } else {
                if (!isLetter(startChar)) {
                    start++;
                }
                if (!isLetter(endChar)) {
                    end--;
                }
            }
        }
        return new String(chars);
    }
    private void swap (char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}
