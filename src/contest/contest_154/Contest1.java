package contest.contest_154;

/**
 * @author luodaihua
 * Created on 2019-09-15
 */
class Contest1 {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }
        int max = Integer.MAX_VALUE;
        for (char c : "balon".toCharArray()) {
            if ('l' == c  || c == 'o') {
                max = Math.min(max, freq[c - 'a'] / 2);
            } else {
                max = Math.min(max, freq[c - 'a']);
            }
        }
        return max;
    }
}
