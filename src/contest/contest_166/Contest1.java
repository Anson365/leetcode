package contest.contest_166;

/**
 * @author Anson
 * Created on 2019-12-08
 */
class Contest1 {
    public int subtractProductAndSum(int n) {
        long a = 1;
        int d = 0;
        while (n > 0) {
            a *= n % 10;
            d += n % 10;
            n /= 10;
        }
        return (int)(a - d);
    }
}
