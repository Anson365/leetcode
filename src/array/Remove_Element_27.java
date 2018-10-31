package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/31/18.
 */
public class Remove_Element_27 {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int num : nums) {
            if (num != val) {
                nums[pointer] = num;
                pointer++;
            }
        }
        return pointer;
    }
}
