import BaseConstruction.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ludao on 2017/3/16.
 */
public class Test {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (tail2 < 0 || (tail1 >= 0 && nums1[tail1] > nums2[tail2])) {
                nums1[i] = nums1[tail1--];
            } else {
                nums1[i] = nums2[tail2--];
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);

    }
}
