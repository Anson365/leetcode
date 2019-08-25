package contest.contest_bi_7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-08-24
 */
class Contest1 {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        int result = 0;
        int index = 0;
        for (char c : word.toCharArray()) {
            int tmp = map.get(c);
            result += Math.abs(tmp - index);
            index = tmp;
        }
        return result;
    }
}
