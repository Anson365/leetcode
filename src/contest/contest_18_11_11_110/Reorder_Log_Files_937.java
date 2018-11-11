package contest.contest_18_11_11_110;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/11/18.
 */
public class Contest1 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digList = new ArrayList<>();
        List<String> alpList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String log : logs) {
            String temp = log.substring(log.indexOf(" ",0) + 1);
            char c = temp.charAt(0);
            if (c >= '0' && c <= '9') {
                digList.add(temp);
            } else {
                alpList.add(temp);
            }
            map.put(temp, log);
        }
        alpList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < alpList.size(); i++) {
            logs[i] = map.get(digList.get(i));
        }
        for (int i = 0; i < digList.size(); i++) {
            logs[i + alpList.size()] = map.get(digList.get(i));
        }
        return logs;
    }

    public static void main(String[] args) {
        Contest1 contest1 = new Contest1();
        contest1.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
    }
}
