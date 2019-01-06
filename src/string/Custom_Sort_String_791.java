package string;

import java.util.Arrays;

/**
 * Created by Anson on 1/6/19.
 */
public class Custom_Sort_String_791 {
    public String customSortString(String S, String T) {
        int[] freq = new int[26];
        for (int i = 0; i < S.length(); i++) {
            freq[S.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char s : S.toCharArray()) {
            while (freq[s - 'a']-- > 0) {
                sb.append(s);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                sb.append((char) i + 'a');
            }
        }
        return sb.toString();
    }
}
