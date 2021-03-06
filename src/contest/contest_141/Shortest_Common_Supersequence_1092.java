package contest.contest_141;

/**
 * @author luodaihua
 * Created on 2019-06-16
 */
public class Shortest_Common_Supersequence_1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int index = dp[m][n];
        String str = "";
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1))

            {
                str += (str1.charAt(i - 1));
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str += (str2.charAt(j - 1));
                j--;
                index--;
            } else {
                str += (str1.charAt(i - 1));
                i--;
                index--;
            }
        }
        while (i > 0) {
            str += (str1.charAt(i - 1));
            i--;
            index--;
        }
        while (j > 0) {
            str += (str2.charAt(j - 1));
            j--;
            index--;
        }

        str = reverse(str);
        return str;
    }

    private String reverse(String input) {
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;

        for (left = 0; left < right; left++, right--) {
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        return String.valueOf(temparray);
    }
}
