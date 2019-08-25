package contest.contest_151;

/**
 * @author luodaihua
 * Created on 2019-08-25
 */
class Contest2 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsArray = new int[2001];
        for (String word : words) {
            wordsArray[helper(word)]++;
        }
        int sum = 0;
        int temp = 0;
        for (int i = 2000; i >= 0; i--) {
            int t = wordsArray[i];
            sum += temp;
            wordsArray[i] = sum;
            temp = t;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = wordsArray[helper(queries[i])];
        }
        return res;
    }

    private int helper(String str) {
        char[] tempArray = str.toCharArray();
        char min = tempArray[0];
        char freq = 1;
        for (int i = 1; i < tempArray.length; i++) {
            char c = tempArray[i];
            if (c < min) {
                min = c;
                freq = 1;
            } else if (c == min){
                freq ++;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        Contest2 contest2 = new Contest2();
        contest2.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
    }
}
