package greedy;

/**
 * 贪心算法（Greedy）
 * 一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而导致结果是最好或最优的算法
 *
 * 例题（see https://leetcode.com/problems/jump-game/description/）
 * 给一个非负数组，你一开始在数组的第一个位置，数组中的每一个元素代表你能跳越的最大步数
 * 请判断你是否能跳到数组最后一个位置
 * 如：A = [2,3,1,1,4], return true.
 *    A = [3,2,1,0,4], return false.
 * 思考题：同是最优子结构 greedy与dp 的区别？
 */
public class JumpGram {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0;i < nums.length;i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}
