package contest.contest_bi_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-09-07
 */
class Contest2 {


    public String[] beforeAndAfterPuzzles(String[] phrases) {
        List<String> res = new ArrayList<>();
        Arrays.sort(phrases);
        Map<String, List<String>> map = new HashMap<>();
        for (String phrase : phrases) {
            int end = phrase.indexOf(" ");
            end = end == -1 ? phrase.length() : end;
            String start = phrase.substring(0, end);
            List<String> temp = map.getOrDefault(start, new ArrayList<>());
            temp.add(phrase);
            map.put(start, temp);
        }
        for (String phrase : phrases) {
            if (map.containsKey(endStr(phrase))) {
                String endStr = endStr(phrase);
                for (String str : map.get(endStr(phrase))) {
                    if (str.length() == endStr.length()) {
                        res.add(phrase);
                    } else {
                        res.add(phrase + str.substring(endStr.length()));
                    }
                }
            }
        }
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    private String endStr(String phrase) {
        int start = phrase.lastIndexOf(" ");
        start = start == -1 ? 0 : start + 1;
        String startStr = phrase.substring(start, phrase.length());
        return startStr;
    }

}
