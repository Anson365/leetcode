package contest.contest_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-08-18
 */
public class Contest4 {
    public String lastSubstring(String s) {
        String res = s;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1) || s.charAt(i) < res.charAt(0)) {
                continue;
            }
            if (res.compareTo(s.substring(i)) <= 0) {
                res = s.substring(i);
            }
        }
        return res;
    }
}
