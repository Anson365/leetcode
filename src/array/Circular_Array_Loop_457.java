package array;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-02-27
 */
public class Circular_Array_Loop_457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        int currentIndex = 0;
        while(!visited[currentIndex]) {
            int next = currentIndex + nums[currentIndex];
            if (next >= nums.length) {
                next = next % nums.length;
            } else if (next < 0) {
                next = nums.length + next % nums.length;
            }
            visited[currentIndex] = true;
            currentIndex = next;
        }
        int startIndex = currentIndex;
        visited = new boolean[nums.length];
        while(!visited[currentIndex]) {
            int next = currentIndex + nums[currentIndex];
            if (next >= nums.length) {
                next = next % nums.length;
            } else if (next < 0) {
                next = nums.length + next % nums.length;
            }
            visited[currentIndex] = true;
            currentIndex = next;
        }
        int cycleSize = 0;
        for (boolean temp : visited) {
            if (temp) {
                cycleSize++;
            }
        }
        return currentIndex == startIndex && cycleSize > 2;
    }

    public static void main(String[] args) {
        Circular_Array_Loop_457 circular_array_loop_457 = new Circular_Array_Loop_457();
        circular_array_loop_457.circularArrayLoop(new int[]{-8,-1,1,7,2});
    }
}
