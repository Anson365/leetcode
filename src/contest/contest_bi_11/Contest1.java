package contest.contest_bi_11;

/**
 * @author Anson <luodaihua@kuaishou.com>
 * Created on 2019-10-19
 */
class Contest1 {
    public int missingNumber(int[] arr) {
        int length = arr.length;
        int diffs = arr[length - 1] - arr[0];
        int diff = diffs / length;
        int temp = arr[0];
        for (int i = 1; i < length; i++) {
            temp += diff;
            if (arr[i] != temp) {
                return temp;
            }
        }
        return -1;
    }

}
