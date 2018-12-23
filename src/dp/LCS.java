package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/29.
 */
public class LCS {
    public int doLCS(String strA,String strB){
        char[] charsA = strA.toCharArray();
        char[] charsB = strB.toCharArray();
        int[][] dp = new int[charsA.length+1][charsB.length+1];
        for(int i=1;i<=charsA.length;i++){
            for(int j=1;j<=charsB.length;j++){
                if(charsA[i-1]==charsB[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[charsA.length][charsB.length];
    }


//    public static void main(String[] args){
//        LCS lcs = new LCS();
//        String a = "asdfasdf";
//        String b = "asdfkksndsdf";
//        System.out.println(lcs.doLCS(a,b));
//    }
}
