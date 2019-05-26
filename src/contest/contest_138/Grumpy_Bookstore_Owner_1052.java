package contest.contest_138;

/**
 * @author luodaihua
 * Created on 2019-05-26
 */
public class Grumpy_Bookstore_Owner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left = 0;
        int right = 0;
        int length = customers.length;
        for (int i = 0; i < X; i++) {
            left += customers[i];
        }
        for (int i = X; i < length; i++) {
            if (grumpy[i] == 0) {
                right += customers[i];
            }
        }
        int max = left + right;
        int temp = left + right;
        for (int i = 1; i < length - X + 1; i++) {
            if (grumpy[i - 1] == 1) {
                temp -= customers[i - 1];
            }
            if (grumpy[i + X - 1] == 1) {
                temp += customers[i + X - 1];
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
