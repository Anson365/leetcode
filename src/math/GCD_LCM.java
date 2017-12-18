package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/18.
 */
public class GCD_LCM {

    public static int doGCD(int m,int n){
        if(m<n){
            return doGCD(n,m);
        }
        if(n==0){
            return m;
        }else {
            return doGCD(n,m%n);
        }
    }


    public static int doLCM(int m,int n){
        int gcd = doGCD(m,n);
        return (m*n/gcd);
    }


    public static void main(String[] args){
        int m=99 ,n=135;
        int lcm = doLCM(m,n);
        System.out.println(lcm);
    }
}
