package contest.contest_bi_8;

/**
 * @author luodaihua
 * Created on 2019-09-07
 */
class Contest1 {
    public int countLetters(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ) {
            int j = i;
            while (s.charAt(i) == s.charAt(j) && j < s.length()) {
                j++;
            }
            int n = j -i;
            res += (1 + n) * n / 2;
            i = j;
        }
        return res;
    }
}
