package contest.contest_153;

/**
 * @author luodaihua
 * Created on 2019-09-08
 */
class Contest3 {

    public int maximumSum(int[] arr) {
        int n = arr.length;
        int a1[] = new int[n];
        int a2[] = new int[n];
        int tempMax = arr[0], max = arr[0];
        a1[0] = arr[0];
        for (int i = 1; i < n; i++) {
            tempMax = Math.max(arr[i], tempMax + arr[i]);
            max = Math.max(max, tempMax);
            a1[i] = tempMax;
        }

        tempMax = max = a2[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            tempMax = Math.max(arr[i], tempMax + arr[i]);
            max = Math.max(max, tempMax);
            a2[i] = tempMax;
        }

        int res = max;
        for (int i = 1; i < n - 1; i++)
            res = Math.max(res, a1[i - 1] + a2[i + 1]);

        return res;
    }
}
