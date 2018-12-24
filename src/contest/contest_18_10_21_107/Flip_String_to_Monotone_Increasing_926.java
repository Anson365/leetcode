package contest.contest_18_10_21_107;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/21/18.
 */
public class Flip_String_to_Monotone_Increasing_926 {
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int flipZeroCount = 0, flipOneCount = 0;
        for (char c : chars) {
            flipOneCount = Math.min(flipOneCount, flipZeroCount) + (c == '1' ? 0 : 1);
            flipZeroCount += (c == '0' ? 0 : 1);
        }
        return Math.min(flipZeroCount, flipOneCount);
    }

//    public static void main(String[] args) {
//        Flip_String_to_Monotone_Increasing_926 flip_string_to_monotone_increasing_926 = new Flip_String_to_Monotone_Increasing_926();
//        flip_string_to_monotone_increasing_926.minFlipsMonoIncr("010110");
//    }
}
