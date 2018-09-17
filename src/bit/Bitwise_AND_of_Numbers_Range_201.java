package bit;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/16/18.
 */
public class Bitwise_AND_of_Numbers_Range_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m <<= count;
    }

    public static void main(String[] args) {
        Bitwise_AND_of_Numbers_Range_201 bitwise_and_of_numbers_range_201 = new Bitwise_AND_of_Numbers_Range_201();
        bitwise_and_of_numbers_range_201.rangeBitwiseAnd(3, 4);
    }
}
