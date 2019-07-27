package contest.contest_bi_5;

/**
 * @author luodaihua
 * Created on 2019-07-27
 */
public class Armstrong_Number_1134 {
    public boolean isArmstrong(int N) {
        String nStr = String.valueOf(N);
        int length = nStr.length();
        long sum = 0;
        for (char c : nStr.toCharArray()) {
            sum += Math.pow(c - '0', length);
        }
        return N == sum;
    }
}
