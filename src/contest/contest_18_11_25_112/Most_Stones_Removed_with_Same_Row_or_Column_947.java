package contest.contest_18_11_25_112;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/25/18.
 */
public class Most_Stones_Removed_with_Same_Row_or_Column_947 {

    private int count = 0;

    public int removeStones(int[][] stones) {
        Map<String, String> parent = new HashMap<>();
        count = stones.length;

        for (int[] stone :stones) {
            String s = buildUnionStr(stone);
            parent.put(s, s);
        }
        for (int[] s1 : stones) {
            String ss1 = buildUnionStr(s1);
            for (int[] s2 : stones) {
                if (s1[0] == s2[0] || s1[1] == s2[1]) {
                    String ss2 = buildUnionStr(s2);
                    union(parent, ss1, ss2);
                }
            }
        }
        return stones.length - count;
    }


    private String buildUnionStr(int[] stone) {
        return stone[0] + " " + stone[1];
    }


    private void union(Map<String, String> parent, String s1, String s2) {
        String r1 = find(parent, s1), r2 = find(parent, s2);
        if (r1.equals(r2)) {
            return;
        }
        parent.put(r1, r2);
        count--;
    }

    private String find(Map<String, String> parent, String s) {
        if (!s.equals(parent.get(s))) {
            parent.put(s, find(parent, parent.get(s)));
        }
        return parent.get(s);
    }
}
