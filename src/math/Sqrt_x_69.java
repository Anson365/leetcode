package math;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/26/18.
 */
public class Sqrt_x_69 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int high = x / 2, low = 1;
        while (high >= low) {
            long middle = low + (high - low) / 2;
            if (middle * middle == x) {
                return (int)middle;
            } else if (middle * middle <x) {
                low = (int)middle + 1;
            } else {
                high = (int)middle - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Sqrt_x_69 sqrt_x_69 = new Sqrt_x_69();
        sqrt_x_69.mySqrt(2147395599);
    }
}