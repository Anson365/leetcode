package math;

/**
 * Created by ludao on 2017/6/29.
 */
public class PowerofThree_326 {
    public boolean isPowerOfThree(int n) {
        return Math.log10(n)/Math.log10(3)%1==0;
    }
}
