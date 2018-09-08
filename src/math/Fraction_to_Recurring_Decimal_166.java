package math;

import array.Find_the_Duplicate_Number_287;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/8/18.
 */
public class Fraction_to_Recurring_Decimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder tempResult = new StringBuilder();
        int factor = (numerator >= 0 && denominator > 0 || numerator < 0 && denominator < 0) ? 1 : -1;
        long tempNumerator = Math.abs((long)numerator);
        long tempDenominator = Math.abs((long)denominator);
        long integer = tempNumerator / tempDenominator;
        if (tempNumerator % tempDenominator == 0) {
            return factor * integer + "";
        } else {
            tempResult.append(integer).append(".");
        }
        long dividend = (tempNumerator % tempDenominator) * 10, remainder = tempNumerator % tempDenominator;
        Map<Long, String> tempMap = new HashMap<>();
        while (remainder != 0) {
            StringBuilder temp = new StringBuilder();
            long originalDividend = dividend;
            while (tempMap.containsKey(dividend)) {
                temp.append(tempMap.get(dividend));
                dividend = (dividend % tempDenominator) * 10;
                if (dividend == originalDividend) { //start to repeat
                    String stopResult = tempResult.toString().replaceAll(temp.toString(), "(" + temp + ")");
                    if (factor < 0) {
                        return "-" + stopResult;
                    }
                    return stopResult;
                }
            }
            while (dividend < tempDenominator) {
                temp.append("0");
                tempMap.put(dividend, "0");
                dividend = dividend * 10;
            }
            long quotient = dividend/tempDenominator;
            temp.append(dividend/tempDenominator);
            remainder = dividend % tempDenominator;
            tempMap.put(dividend, quotient + "");
            dividend = remainder * 10;
            tempResult.append(temp);
        }
        if (factor < 0) {
            return "-" + tempResult;
        }
        return tempResult.toString();
    }


    //way2 to put the quitient,index into the map and when the map contains
    // the key just insert the( and ) into the result then return

    public static void main(String[] args) {
        Fraction_to_Recurring_Decimal_166 fraction_to_recurring_decimal_166 = new Fraction_to_Recurring_Decimal_166();

        fraction_to_recurring_decimal_166.fractionToDecimal(-1, -2147483648);
    }
}
