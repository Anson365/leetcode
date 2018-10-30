package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/29/18.
 */
public class Sum_of_Square_Numbers_633 {
    public boolean judgeSquareSum(int c) {
        int low = 0, high = (int) Math.sqrt(c);
        while (low <= high) {
            int temp = low * low + high * high;
            if (temp == c) {
                System.out.println(low + ":" + high);
                return true;
            } else if (temp < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
}
