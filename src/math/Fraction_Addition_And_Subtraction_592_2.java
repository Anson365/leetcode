package math;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/13/18.
 */
public class Fraction_Addition_And_Subtraction_592_2 {
    public String fractionAddition(String expression) {
        String[] tempArray = expression.split("(?=[-|+])");
        String tempStr = "0/1";
        for (String temp : tempArray) {
            tempStr = helper(tempStr, temp);
        }
        int[] array = Stream.of(tempStr.split("/")).mapToInt(Integer::parseInt).toArray();
        int numerator = array[0];
        int denominator = array[1];
        String sign = "";
        if (numerator < 0) {
            sign = "-";
            numerator = -numerator;
        }
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return sign + numerator + "/" + denominator;
    }
    private String helper(String factor1, String factor2) {
        int[] array1 = Stream.of(factor1.split("/")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Stream.of(factor2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numerator = array1[0] * array2[1] + array2[0] * array1[1];
        int denominator = array1[1] * array2[1];
        return numerator + "/" + denominator;

    }
    private int gcd(int x, int y) {
        if (x == 0 || y == 0) {
            return y + x;
        } else {
            return gcd(y, x%y);
        }
    }

//    public static void main(String[] args){
//        String temp = "-5/2+10/3+7/9";
//        Fraction_Addition_And_Subtraction_592_2 fractionAdditionandSubtraction_592
//                = new Fraction_Addition_And_Subtraction_592_2();
//        String result = fractionAdditionandSubtraction_592.fractionAddition(temp);
//        System.out.println(result);
//    }
}
