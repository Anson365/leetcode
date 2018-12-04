package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/4/18.
 */
public class Reverse_Vowels_of_A_String_345 {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int start = 0, end = s.length() - 1;
        char[] temp = s.toCharArray();
        while (start < end) {
            while (start < end && !vowels.contains(temp[start] + "")) {
                start++;
            }
            while (end > start && !vowels.contains(temp[end] + "")) {
                end--;
            }
            if (end <= start) {
                return new String(temp);
            } else {
                char tempChar = temp[start];
                temp[start] = temp[end];
                temp[end] = tempChar;
                start++;
                end--;
            }
        }
        return new String(temp);
    }
}
