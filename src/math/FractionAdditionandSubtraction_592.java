package math;

import java.util.stream.Stream;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/7/29.
 */
public class FractionAdditionandSubtraction_592 {

    public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-+])"); // splits input string into individual fractions
        String res = "0/1";
        for (String frac : fracs) res = add(res, frac); // add all fractions together
        return res;
    }

    public String add(String frac1, String frac2) {
        int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray(),
                f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numer = f1[0]*f2[1] + f1[1]*f2[0], denom = f1[1]*f2[1];
        String sign = "";
        if (numer < 0) {sign = "-"; numer *= -1;}
        int gcd = gcd(numer,denom);
        return sign + numer/gcd + "/" + denom/gcd; // construct reduced fraction
    }

    // Computes gcd using Euclidean algorithm
    public int gcd(int x, int y) { return x == 0 || y == 0 ? x + y : gcd(y, x % y); }
//    public static void main(String[] args){
//        String temp = "-5/2+10/3+7/9";
//        FractionAdditionandSubtraction_592 fractionAdditionandSubtraction_592
//                = new FractionAdditionandSubtraction_592();
//        String result = fractionAdditionandSubtraction_592.fractionAddition(temp);
//        System.out.println(result);
//    }
}
