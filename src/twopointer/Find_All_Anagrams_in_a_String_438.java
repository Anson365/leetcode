package twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-03-12
 */
public class Find_All_Anagrams_in_a_String_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        int[] target = new int[26];
        int[] source = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
            source[s.charAt(i) - 'a']++;
        }
        if (helper(source, target)) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            source[s.charAt(i - p.length()) - 'a']--;
            source[s.charAt(i) - 'a']++;
            if (helper(source, target)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    private boolean helper(int[] s, int[] t) {
        for (int i = 0; i < 26; i++) {
            if (s[i] != t[i]) {
                return false;
            }
        }
        return true;
    }
}
