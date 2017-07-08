package math;

/**
 * Created by ludao on 2017/7/8.
 */
public class AddDigits_258 {
    public int addDigits(int num) {
        if(num==0)
            return 0;
        if(num%9==0)
            return 9;
        return num%9;
    }
}
