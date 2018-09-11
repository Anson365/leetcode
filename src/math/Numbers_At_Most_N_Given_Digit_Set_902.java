package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/10/18.
 */
public class Numbers_At_Most_N_Given_Digit_Set_902 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String tempN = N + "";
        int length = tempN.length();
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            sum += Math.pow(D.length, i + 1);
        }
        int[] dp = new int[length + 1];
        dp[length] = 1;

         for(int i = tempN.length() - 1; i >= 0; i--) {
            String charN = tempN.charAt(i) + "";
            for (String temp : D) {
                if (temp.compareTo(charN) < 0) {
                    dp[i] +=  Math.pow(D.length, tempN.length() - i - 1);
                } else if (temp.compareTo(charN) == 0) {
                    dp[i] += (dp[i + 1]);
                } else {
                    break;
                }
            }
        }
        return dp[0] + sum;
    }

    public static void main(String[] args) {
        Numbers_At_Most_N_Given_Digit_Set_902 numbers_at_most_n_given_digit_set_902 = new Numbers_At_Most_N_Given_Digit_Set_902();
        String[] D = {"7"};
        int N = 8;
        numbers_at_most_n_given_digit_set_902.atMostNGivenDigitSet(D, N);
    }

}
