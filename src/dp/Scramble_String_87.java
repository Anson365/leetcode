package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/11/18.
 */
public class Scramble_String_87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            a[s2.charAt(i) - 'a']--;
        }
        for (int temp : a) {
            if (temp != 0) {
                return false;
            }
        }
        int length = s1.length();
        for (int i = 1; i < length; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(length - i))
                    && isScramble(s1.substring(i), s2.substring(0, length - i))) {
                return true;
            }
        }
        return false;
    }
}
