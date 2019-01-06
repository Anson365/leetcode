package contest.contest_19_01_06_118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson on 1/6/19.
 */
public class Pancake_Sorting_960 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int length = A.length, tempMax = length;
        for (int i = 0; i < length; i++) {
            int index = findIndex(A, tempMax);
            if (index + 1 == tempMax) {
                tempMax--;
                continue;
            }
            doReverse(A, index);
            doReverse(A, tempMax - 1);
            result.add (index + 1);
            result.add(tempMax--);
        }
        return result;
    }

    private int findIndex(int[] A, int target) {
        for (int i = 0; i < target; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private void doReverse(int[] A, int index) {
        for (int i = 0; i <= index/2; i++) {
            int temp = A[i];
            A[i] = A[index - i];
            A[index - i] = temp;
        }
    }

    public static void main(String[] args) {
        Pancake_Sorting_960 pancakeSorting960 = new Pancake_Sorting_960();
        pancakeSorting960.pancakeSort(new int[]{3,2,4,1});
    }
}
