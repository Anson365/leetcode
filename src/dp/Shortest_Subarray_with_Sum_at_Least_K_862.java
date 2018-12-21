package dp;

import java.util.LinkedList;

/**
 * Created by Anson on 12/20/18.
 */
public class Shortest_Subarray_with_Sum_at_Least_K_862 {

    public int shortestSubarray(int[] A, int K) {
        int result = A.length + 1;
        int[] sumArray = new int[A.length + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < A.length; i++) {
            sumArray[i + 1] = sumArray[i] + A[i];
        }

        for(int i = 0; i < sumArray.length; i++) {
            while (queue.size() > 0 && sumArray[i] - sumArray[queue.peekFirst()] >= K) {
                result = Math.min(result, i - queue.pollFirst());
            }
            while (queue.size() > 0 && sumArray[i] <= sumArray[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        return result <= A.length ? result : -1;
    }

    public static void main(String[] args) {
        Shortest_Subarray_with_Sum_at_Least_K_862 shortest
                = new Shortest_Subarray_with_Sum_at_Least_K_862();
        shortest.shortestSubarray(new int[]{84,-37,32,40,95}, 167);
    }
}
