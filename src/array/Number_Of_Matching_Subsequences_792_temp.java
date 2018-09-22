package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/21/18.
 */
public class Number_Of_Matching_Subsequences_792_temp {
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        List<MiddleClass> list = new ArrayList<>();
        for (String word : words) {
            if (helper(S, word, list)) {
                result++;
            }
        }
        return result;
    }

    private boolean helper (String s, String t, List<MiddleClass> list) {
        int tStart = 0, index = 0;
        for (int i = 0; i < list.size() && tStart < t.length(); i++) {
            if (t.charAt(tStart) == list.get(i).value) {
                tStart++;
                index = i;
            }
        }
        if (tStart == t.length()) {
            return true;
        }
        for (int i = index + 1; i < s.length() && tStart < t.length(); i++) {
            if (t.charAt(tStart) == s.charAt(i)) {
                index = addList(index, s, i, list);
                tStart++;
            }
        }
        return tStart == t.length();

    }

    private int addList(int index, String s, int charIndex, List<MiddleClass> list) {
        for (int i = index; i < list.size(); i++) {
            MiddleClass temp = list.get(i);
            if (temp.index > index) {
                list.add(i, new MiddleClass(s.charAt(charIndex), charIndex));
                return i;
            }
        }
        list.add(new MiddleClass(s.charAt(charIndex), charIndex));
        return list.size();
    }

    class MiddleClass {
        private char value;
        private int index;

        public MiddleClass(char value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
