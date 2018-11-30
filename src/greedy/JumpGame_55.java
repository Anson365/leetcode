package greedy;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/28/18.
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int maxStep = nums[0];
        for (int i = 0; i < nums.length && maxStep >= i; i++) {
            int temp = nums[i] + i;
            if (temp > nums.length - 2) {
                return true;
            } else {
                maxStep = Math.max(temp, maxStep);
            }
        }
        return false;
    }
}
