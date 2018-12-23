package contest.contest_18_11_25_112;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/25/18.
 */
public class Bag_of_Tokens_948 {
    public int bagOfTokensScore_I(int[] tokens, int P) {
        TreeMap<Integer, Integer> treeSet = new TreeMap<>();
        for (int token : tokens) {
            treeSet.put(token, treeSet.getOrDefault(token, 0) + 1);
        }
        int point = 0, result = 0;
        while (treeSet.size() != 0) {
            Integer temp = treeSet.floorKey(P);
            if (temp != null) {
                if (treeSet.subMap(treeSet.firstKey(), true, temp, true).size() >= treeSet.size() / 2  ) {
                    temp = treeSet.firstKey();
                }
                P -= temp;
                point++;
                result = Math.max(point, result);
                if (treeSet.get(temp) - 1 <= 0) {
                    treeSet.remove(temp);
                } else {
                    treeSet.put(temp, treeSet.get(temp) - 1);
                }
            } else {
                if (point <= 0) {
                    return result;
                } else {
                    Integer largest =  treeSet.lastKey();
                    point--;
                    P += largest;
                    if (treeSet.get(largest) - 1 <= 0) {
                        treeSet.remove(largest);
                    } else {
                        treeSet.put(largest, treeSet.get(largest) - 1);
                    }
                }
            }
        }
        return result;
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int count = 0;
        int point = 0;
        int start = 0;
        int end = tokens.length - 1;
        while (start <= end) {
            if (P >= tokens[start]) {
                P -= tokens[start];
                start++;
                point++;
                count = Math.max(count, point);
            } else {
                if (point <= 0) {
                    return count;
                } else {
                    P += tokens[end];
                    point--;
                    end--;
                }
            }
        }
        return count;
    }

//    public static void main(String[] args) {
//        Bag_of_Tokens_948 bagofTokens948 = new Bag_of_Tokens_948();
//        bagofTokens948.bagOfTokensScore(new int[]{87,24,32},87);
//    }
}
