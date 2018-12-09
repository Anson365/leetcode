package contest.contest_18_12_09_114;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/8/18.
 */
public class Delete_Columns_To_Make_Sorted_II_955 {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            if (!isSorted(A, i + 1)) {
                delete(A, i--);
                count++;
            }
        }
        return count;
    }
    private boolean isSorted(String[] arr, int end) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].substring(0, end).compareTo(arr[i].substring(0, end)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void delete(String[] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substring(0, index) + arr[i].substring(index + 1);
        }
    }
    public static void main(String[] args) {
        Delete_Columns_To_Make_Sorted_II_955 deleteColumnsToMakeSortedII955 = new Delete_Columns_To_Make_Sorted_II_955();
        deleteColumnsToMakeSortedII955.minDeletionSize(new String[]{"a","z","b","c","d"});
    }
}
