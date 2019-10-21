package contest.contest_159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Anson
 * Created on 2019-10-20
 */
class Contest2 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String target = folder[0];
        Set<String> res = new HashSet<>();
        for (int i = 1; i < folder.length; i++) {
            String temp = folder[i];
            if (temp.startsWith(target + "/")) {
                continue;
            } else {
                res.add(target);
                target = temp;
            }
        }
        if (!res.contains(target)) {
            res.add(target);
        }
        return new ArrayList<>(res);
    }


}
