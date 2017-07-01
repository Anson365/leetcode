package math;

import number.UglyNumber2_264;

/**
 * Created by ludao on 2017/7/1.
 */
public class IntegertoRoman_12 {

    //个位
    private String[] unit = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    //十位
    private String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    //百位
    private String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    //千位
    private String[] kilobit = {"", "M", "MM", "MMM"};

    public String intToRoman(int num) {
        return kilobit[num/1000] + hundreds[num%1000/100] + ten[num%100/10] + unit[num%10];
    }
}
