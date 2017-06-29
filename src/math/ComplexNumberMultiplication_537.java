package math;

/**
 * Created by ludao on 2017/6/28.
 */
public class ComplexNumberMultiplication_537 {
    public String complexNumberMultiply(String a, String b) {
        String[] aArray = a.split("\\+");
        String[] bArray = b.split("\\+");
        int m = Integer.valueOf(aArray[0]);
        int n = Integer.valueOf(bArray[0]);

        int mi = Integer.valueOf(aArray[1].replaceAll("i",""));
        int ni = Integer.valueOf(bArray[1].replaceAll("i",""));

        int aResult = m*n-mi*ni;
        int bResult = m*ni+n*mi;

        return aResult+"+"+bResult+"i";
    }
}
