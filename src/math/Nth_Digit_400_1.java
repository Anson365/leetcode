package math;

/**
 * @author luodaihua
 * Created on 2019-03-14
 */
public class Nth_Digit_400_1 {

    public int findNthDigit(int n) {
        long count = 1, factor = 9, range = 9, lastRange = 0, base = 1;
        if (n < 10) {
            return n;
        }
        while (range < n) {
            base *= 10;
            count++;
            factor *= 10;
            lastRange = range;
            range += (count * factor);
        }
        long temp = n - lastRange - 1;
        long num = base + temp / count;
        int result = (num + "").charAt((int) (temp % count)) - '0';
        return result;
    }
}
