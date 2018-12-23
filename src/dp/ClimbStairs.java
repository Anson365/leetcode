package dp;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * n级阶梯，每次只能爬一级或者二级，问爬完n级台阶一共有多少种方法
 * 动态规划（Dynamic Programming）
 * 三大特性
 * 1. 最优子结构，即当前问题的最优解必然基于其子问题的最优解
 * 2. 重叠子问题，即解决当前问题和解决其子问题的方法一致或者相似（可用递归，但是一般用内存记录之前的状态，防止重复计算，典型的以空间换时间）
 * 3. 无后效性，即某一确定状态之后的发展与该状态之前的状态无关
 *
 * 题目解析：每次只能爬一级或者二级台阶，那么最后一次到n 只能是从 n-1 或者 n-2 (重叠子问题)
 *         方法数f(n) = f(n-1) + f(n-2) （最优子结构）
 *         f(n)的状态只与其子问题f(n-1)和f(n-2)有关,和f(n-1)及f(n-2)的子问题无关 （无后效性）
 * 附加题：LCS（最长公共子序列长度，如 asdfasdf 和 asdfkksndsdf 的最长公共子序列是asdfsdf 长度为7）
 */
public class ClimbStairs {
    public int doClimb(int n){
        int[] dp = new int[n + 1];       // 开辟存储空间，方便计数 数组长度为n + 1
        dp[0] = 1;                       // 方便处理规定0 为1
        for (int i = 1;i < n + 1; i++) { // 从 1开始 即先求子问题，由子到父 （重叠的子问题）
            if (i == 1) {                // 特殊值 直接处理
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[i-2]; //最优子结构， 无后效性
            }
        }
        return dp[n];
    }


//    public static void main(String[] args){
//        int result = new ClimbStairs().doClimb(10);
//        System.out.println(result);
//    }
}
