package string;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/13/18.
 */
public class Rearrange_String_K_Distance_Apart_358 {
    public String rearrangeString(String s, int k) {
        int length = s.length();
        int[] temp = new int[26];
        int[] valid = new int[26];
        for (char c : s.toCharArray()) {
            temp[c - 'a']++;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int tempIndex = helper(temp, valid, i);
            if (tempIndex < 0) {
                return "";
            }
            valid[tempIndex] = i + k;
            str.append((char)('a' + tempIndex));
        }
        return str.toString();
    }

    private int helper(int[] temp, int[] valid, int index) {
        int max = 0;
        int tempIndex =  -1;
        for (int i = 0; i < 26; i++) {
            if (temp[i] > 0 && temp[i] > max && index >= valid[i]) {
                max = temp[i];
                tempIndex = i;
            }
        }
        return tempIndex;
    }

    public static void main(String[] args) {
        Rearrange_String_K_Distance_Apart_358 rearrange_string_k_distance_apart_358 = new Rearrange_String_K_Distance_Apart_358();
        rearrange_string_k_distance_apart_358.rearrangeString("aaabbcc",3);
    }
}
