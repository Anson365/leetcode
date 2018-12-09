package contest.contest_18_12_09_114;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/8/18.
 */
public class Verifying_An_Alien_Dictionary_953 {
    public boolean isAlienSorted_II(String[] words, String order) {
        String[] oldWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            oldWords[i] = words[i];
        }
        Arrays.sort(words, (i1, i2) -> {
            int length1 = i1.length();
            int length2 = i2.length();
            int length = Math.min(length1, length2);
            for (int i = 0; i < length; i++) {
                char char1 = i1.charAt(i);
                char char2 = i2.charAt(i);
                if (order.indexOf(char1 + "") > order.indexOf(char2 + "")) {
                    return 1;
                } else if (order.indexOf(char1 + "") < order.indexOf(char2 + "")) {
                    return -1;
                }
            }
            if (length1 == length2) {
                return 0;
            } else {
                return length1 > length2 ? 1 : -1;
            }
        });
        for (int i = 0; i < words.length; i++) {
            if (words[i] != oldWords[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] memo = new int[26];
        int p = 0;
        for (char c : order.toCharArray()) {
            memo[c - 'a'] = p++;
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            boolean flag = true;
            int length = Math.min(word1.length(), word2.length());
            for (int j = 0; j < length; j++) {
                int memo1 = memo[word1.charAt(j) - 'a'];
                int memo2 = memo[word2.charAt(j) - 'a'];
                if (memo1 > memo2) {
                    return false;
                } else if (memo1 < memo2){
                    flag = false;
                    break;
                }
            }
            if (flag && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}
