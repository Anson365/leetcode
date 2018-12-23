package array;

import java.io.FileWriter;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/5/18.
 */
public class Find_the_Duplicate_Number_287 {
    public int findDuplicate(int[] nums) {
        int length = nums.length, index = 0;
        while (true) {
            int temp1 = nums[index];
            if (nums[temp1 -1 ] != temp1) {
                swap(nums, index, temp1 - 1);
                index = temp1 - 1;
            } else {
                if (temp1 - 1 == index) {
                    index = length - 1;
                    continue;
                }
                return temp1;
            }
        }
    }
    private void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

    public int findDuplicate1(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        int mid = (high + low)/2;
        while (low < high) {
            int count = 0;
            for (int temp : nums) {
                if (temp <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

//    public static void main(String[] args) {
//        Find_the_Duplicate_Number_287 find_the_duplicate_number_287 = new Find_the_Duplicate_Number_287();
//        int[] array = {2,2,2,2,2};
//        int result = find_the_duplicate_number_287.findDuplicate(array);
//        System.out.println(result);
//    }
}
