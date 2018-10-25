package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/25/18.
 * note: the integer out of index
 */
public class Pow_x_n_50 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        } else if (n < 0) {
            return (1/x) * myPow(1/x, -(n + 1));
        } else {
            if (n % 2 == 0) {
                return myPow(x * x, n/2);
            } else {
                return x * myPow(x, n - 1);
            }
        }
    }
}
