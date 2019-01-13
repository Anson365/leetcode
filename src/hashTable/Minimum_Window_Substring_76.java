package hashTable;

import java.util.HashMap;

/**
 * Created by Anson on 1/13/19.
 */
public class Minimum_Window_Substring_76 {

    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        for(int end = 0; end < s.length(); end++) {
            char tempChar = s.charAt(end);
            if(map.containsKey(tempChar)){
                map.put(tempChar, map.get(tempChar) - 1);
                if(map.get(tempChar) >= 0){
                    count++;
                }
                while(count == t.length()){
                    if(end - start + 1 < minLen) {
                        minLeft = start;
                        minLen = end - start + 1;
                    }
                    char startChar = s.charAt(start);
                    if(map.containsKey(startChar)) {
                        map.put(startChar, map.get(startChar) + 1);
                        if(map.get(startChar) > 0){
                            count--;
                        }
                    }
                    start++ ;
                }
            }
        }
        if(minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        Minimum_Window_Substring_76 minimum_window_substring_76 = new Minimum_Window_Substring_76();
        minimum_window_substring_76.minWindow("ab", "a");
    }
}
