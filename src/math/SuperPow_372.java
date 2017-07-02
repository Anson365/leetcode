package math;

/**
 * Created by ludao on 2017/7/2.
 */
public class SuperPow_372 {

    private final Integer M = 1337;

    public int superPow(int a, int[] b) {
        int result = 1;
        for(int i=b.length-1;i>=0;i--){
            result = result*normalPow(a,b[i])%M;
            a = normalPow(a,10);
        }
        return result;
    }


    private int normalPow(int a,int b){
        int result = 1;
        a = a%M;
        while (b != 0){
            if(b%2 != 0){
                result = a*result%M;
            }
            a = a*a%M;
            b = b/2;
        }
        return result;
    }
}
