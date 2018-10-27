package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/27/18.
 */
public class Valid_Perfect_Square_367 {
    // step is 2, the sum of arithmetic progression
    public boolean isPerfectSquare_1(int num) {
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while(low <= high) {
            int middle = low + (high - low) / 2;
            long temp = 1l * middle * middle;
            if (temp > num) {
                high = middle - 1;
            } else if (temp < num) {
                low = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
