package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-04-02
 */
public class Word_Pattern_290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        Map<Character, String> p2StrMap = new HashMap<>();
        Map<String, Character> str2PMap = new HashMap<>();
        if (strArray.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            String tempStr = strArray[i];
            if (p2StrMap.containsKey(temp) && !p2StrMap.get(temp).equals(tempStr)) {
                return false;
            }
            if (str2PMap.containsKey(tempStr) && !str2PMap.get(tempStr).equals(temp)) {
                return false;
            }
            p2StrMap.put(temp, tempStr);
            str2PMap.put(tempStr, temp);
        }
        return true;
    }

    public static void main(String[] args) {
        Word_Pattern_290 word_pattern_290 = new Word_Pattern_290();
        word_pattern_290.wordPattern("abba",
                "dog cat cat dog");

    }
}
