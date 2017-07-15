package binarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ludao on 2017/7/15.
 */
public class RussianDollEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]) return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });
        int length = envelopes.length,result=0;
        int[] dp = new int[length];
        for(int i=0;i<length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;

    }
}
