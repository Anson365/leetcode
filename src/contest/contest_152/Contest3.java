package contest.contest_152;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-09-01
 */
class Contest3 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();

        for (int[] query : queries) {
            String temp = s.substring(query[0], query[1] + 1);
            res.add(helper(temp, query[2]));
        }
        return res;
    }

    private boolean helper(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            int freq = map.getOrDefault(c, 0);
            map.put(c, freq + 1);
        }
        String temp = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                temp += entry.getKey();
            }
        }
        int i = 0;
        int j = temp.length() - 1;
        while (i < j) {
            if (temp.charAt(i) == temp.charAt(j)) {
                i++;
                j--;
            } else {
                if (k > 0) {
                    k--;
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
