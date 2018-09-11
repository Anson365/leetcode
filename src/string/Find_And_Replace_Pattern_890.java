package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/11/18.
 */
public class Find_And_Replace_Pattern_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        pattern = doHelper(pattern);
        for (String word : words) {
            String convertedWord = doHelper(word);
            if (pattern.equals(convertedWord)) {
                result.add(word);
            }
        }
        return result;
    }

    private String doHelper(String words) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 1;
        StringBuilder converted = new StringBuilder();
        for (char c : words.toCharArray()) {
            Integer convert = map.get(c);
            if (convert == null) {
                map.put(c, index);
                convert = index;
                index++;
            }
            converted.append(convert);
        }
        return converted.toString();
    }
}
