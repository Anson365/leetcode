package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/18/18.
 */
public class Distinct_Subsequences_II_930 {
    public int distinctSubseqII(String S) {
        long mod = (long)1e9 + 7;
        long[] endChar = new long[26];
        long sum = 0;
        for (char c : S.toCharArray()) {
            int index = c - 'a';
            long temp = endChar[index];
            endChar[index] = sum % mod + 1;
            sum += (endChar[index] - temp);
        }
        long result = 0;
        for (long count : endChar) {
            result = (result + count) % mod;
        }
        return (int)result;
    }
}
