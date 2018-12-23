package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/3/18.
 */
public class Non_decreasing_Array_665 {
    public boolean checkPossibility(int[] nums) {
        Boolean flag = false;
        for (int i = 0; i + 1< nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                if (flag) {
                    return false;
                }
                boolean current = true, behind = true;
                if (i - 1 >= 0) {
                    if (nums[i - 1] > nums[i + 1]) {
                        current = false;
                    }
                }
                if (i + 1 < nums.length - 1) {
                    if (nums[i] > nums[i + 2]) {
                        behind = false;
                    }
                }
                if (!(current || behind)) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        int[] nums = {2,3,3,2,4};
//        Non_decreasing_Array_665 non_decreasing_array_665 = new Non_decreasing_Array_665();
//        non_decreasing_array_665.checkPossibility(nums);
//    }
}
