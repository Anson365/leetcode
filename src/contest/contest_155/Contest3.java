package contest.contest_155;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author luodaihua
 * Created on 2019-09-22
 */
public class Contest3 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        boolean[] mark = new boolean[pairs.size()];
        char[] resArray = s.toCharArray();
        for (int i = 0; i < pairs.size(); i++) {
            if (mark[i]) {
                continue;
            }
            TreeSet<Integer> set = new TreeSet<>();
            set.add(pairs.get(i).get(0));
            set.add(pairs.get(i).get(1));
            int size = set.size();
            while (true) {
                for (int j = i + 1; j < pairs.size(); j++) {
                    if (mark[j]) {
                        continue;
                    }
                    if (set.contains(pairs.get(j).get(0)) || set.contains(pairs.get(j).get(1))) {
                        mark[j] = true;
                        set.add(pairs.get(j).get(0));
                        set.add(pairs.get(j).get(1));
                    }
                }
                if (size == set.size()) {
                    break;
                }
            }
            char[] tempChar = new char[set.size()];
            int count = 0;
            for (Integer index : set) {
                tempChar[count++] = s.charAt(index);
            }
            Arrays.sort(tempChar);
            count = 0;
            for (Integer index : set) {
                resArray[index] = tempChar[count++];
            }
        }
        return new String(resArray);
    }

}
