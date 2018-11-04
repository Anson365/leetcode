package hashTable;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/1/18.
 */
public class Palindrome_Pairs_336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String s1 = word.substring(0, j);
                String s2 = word.substring(j);
                // left as the palindrome middle
                if (isPalindrome(s1)) {
                    String tempReverse = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(tempReverse) && map.get(tempReverse) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(map.get(tempReverse));
                        pair.add(i);
                        result.add(pair);
                    }
                }
                // right as the palindrome middle
                if (s2.length() != 0 && isPalindrome(s2)) {
                    String tempReverse = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(tempReverse) && map.get(tempReverse) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(map.get(tempReverse));
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String target) {
        int begin = 0, end = target.length() - 1;
        while (begin <= end) {
            if (target.charAt(begin) != target.charAt(end)) {
                return false;
            } else {
                begin ++;
                end --;
            }
        }
        return true;
    }
}
