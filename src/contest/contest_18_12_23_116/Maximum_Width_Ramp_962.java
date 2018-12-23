package contest.contest_18_12_23_116;

/**
 * Created by Anson on 12/23/18.
 */
public class Maximum_Width_Ramp_962 {
    public int maxWidthRamp(int[] A) {
        int length = A.length, max = 0;

        Integer[] dp = new Integer[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] == A[j]) {
                    dp[i] = dp[j];
                    break;
                } else if (A[i] > A[j]) {
                    if (dp[j] == dp[dp[j]]) {
                        if (A[i] == A[dp[j]]) {
                            dp[i] = dp[j];
                            break;
                        } else {
                            dp[i] = dp[j];
                            j = dp[j];
                        }
                    }
                }
            }
            if (dp[i] == null) {
                dp[i]= i;
            }
            max = Math.max(max, i - dp[i]);
        }
        return max;
    }

//    public static void main(String[] args) {
//        Maximum_Width_Ramp_962 maximumWidthRamp962 = new Maximum_Width_Ramp_962();
//        maximumWidthRamp962.maxWidthRamp(new int[]{6,0,8,2,1,5});
//    }
}
