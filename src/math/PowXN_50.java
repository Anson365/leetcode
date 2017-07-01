package math;

/**
 * Created by ludao on 2017/7/1.
 */
public class PowXN_50 {
        public double myPow(double x, int n) {
            if(n==0){
                return 1;
            }
            if(x==0||x==1||n==1){
                return x;
            }
            if(x<0&&n%2==1){
                return -myPow(-x,n);
            }
            if(n<0){
                return myPow(1/x,-n);
            }
            if(n%2==1){
                return myPow(x*x,n-1);
            }else {
                return myPow(x*x,n/2);
            }
        }
}
