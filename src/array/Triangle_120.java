package array;

import java.util.List;

/**
 * Created by ludao on 2017/6/8.
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        for(int i=3;i<triangle.size();i++){
            for(int j=1;j<i;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }

        int result = dp[triangle.size()][0];
        for(int i:dp[triangle.size()-1]){
            result = result>i?i:result;
        }
        return result;
    }


    public int minimumTotal2(List<List<Integer>> triangle){
        int[] dp = new int[triangle.size()];
        for(int i=triangle.size();i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
