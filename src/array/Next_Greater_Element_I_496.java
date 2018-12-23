package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/22/18.
 */
public class Next_Greater_Element_I_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            boolean flag = false, found = false;
            for (int j = 0; j < nums2.length; j++) {
                int temp = nums2[j];
                if (temp == target) {
                    flag = true;
                    continue;
                }
                if (temp > target && flag) {
                    result[i] = temp;
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[i] = -1;
            }
        }
        return result;
    }
//    public static void main(String[] args) {
//        Next_Greater_Element_I_496 next_greater_element_i_496 = new Next_Greater_Element_I_496();
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};
//        next_greater_element_i_496.nextGreaterElement(nums1, nums2);
//    }
}
