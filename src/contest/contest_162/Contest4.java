package contest.contest_162;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anson
 * Created on 2019-11-10
 */
public class Contest4 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put((char) ('a' + i), score[i]);
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : letters) {
            int freq = freqMap.getOrDefault(c, 0);
            freq++;
            freqMap.put(c, freq);
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            int temp = helper(new HashMap<>(freqMap), map, i, words);
            max = Math.max(temp, max);
        }
        return max;
    }

    private int helper(Map<Character, Integer> freqMap, Map<Character, Integer> scoreMap, int start, String[] words) {
        int score = 0;
        for (int i = start; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                if (freqMap.getOrDefault(c, 0) == 0) {
                    return 0;
                } else {
                    freqMap.put(c, freqMap.get(c) - 1);
                }
                score += scoreMap.getOrDefault(c, 0);
            }
        }
        return score;
    }


}
