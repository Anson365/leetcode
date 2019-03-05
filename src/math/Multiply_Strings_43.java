package math;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-03-05
 */
public class Multiply_Strings_43 {
    public String multiply(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int[] resultChar = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int tempNum1 = num1Char[i] - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int tempNum2 = num2Char[j] - '0';
                int tempNum = resultChar[i + j + 1] + tempNum1 * tempNum2;

                resultChar[i + j] = tempNum / 10;
                resultChar[i + j + 1] = tempNum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : resultChar) {
            if ("".equals(sb.toString()) && i == 0) {
                continue;
            }
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Multiply_Strings_43 multiply_strings_43 = new Multiply_Strings_43();
        multiply_strings_43.multiply("2", "3");
    }
}
