package dp;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/29.
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbStairs {


    public int doClimbWithRecursion(int n){
        if (n<=3) {
            return n;
        }else {
            return doClimbWithRecursion(n-1)+doClimbWithRecursion(n-2);
        }
    }

    public int doClimbWithDP(int n){
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i<=3){
                dp[i] = i;
            }else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }


    public static void main(String[] args){
        int result = new ClimbStairs().doClimbWithDP(10);
        System.out.println(result);
    }
}
