package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/7/18.
 */
public class Nth_Digit_400 {
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
        long num = base + temp/count;
        int result = (num + "") .charAt((int)(temp%count)) - 48;
        return result;
    }

    public static void main(String[] args) {
        Nth_Digit_400 nth_digit_400 = new Nth_Digit_400();
        nth_digit_400.findNthDigit(1000000000);
    }
}
