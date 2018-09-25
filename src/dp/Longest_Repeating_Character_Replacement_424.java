package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/24/18.
 */
public class Longest_Repeating_Character_Replacement_424 {
    public int characterReplacement(String s, int k) {
        int index = 0, maxLength = 0, result = 0;
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'A';
            letter[temp]++;
            maxLength = Math.max(letter[temp], maxLength);
            if (i - index + 1 > maxLength + k) {
                letter[s.charAt(index) - 'A']--;
                index++;
            }
            result = Math.max(result, i - index + 1);
        }
        return result;
    }
}
