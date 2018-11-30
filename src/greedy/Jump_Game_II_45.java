package greedy;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/28/18.
 */
public class Jump_Game_II_45 {
    public int jump(int[] nums) {
        int start = 0, maxIndex = nums[0], step = 0;
        while (start < maxIndex) {
            int tempMax = maxIndex;
            step++;
            for (int i = start; i <= maxIndex; i++) {
                int temp = i + nums[i];
                if (temp >= nums.length - 1) {
                    return ++step;
                } else {
                    tempMax = Math.max(temp, tempMax);
                }
            }
            start = maxIndex;
            maxIndex = tempMax;
        }
        return -1;
    }
}
