package bit;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/9/8.
 */
public class PowerofFour_342 {
    public boolean isPowerOfFour(int num) {
        if(num<1){
            return false;
        }
        return Math.log10(num)/Math.log10(4)%1==0;
    }
//    public static void main(String[] args){
//        PowerofFour_342 powerofFour_342 = new PowerofFour_342();
//        powerofFour_342.isPowerOfFour(8);
//    }
}
