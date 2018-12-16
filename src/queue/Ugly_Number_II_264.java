package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/13/18.
 */
public class Ugly_Number_II_264 {
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while(list.size() < n) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;

            int min = Math.min(m2, Math.min(m3, m5));
            if (min == m2) {
                i2++;
            } else if (min == m3) {
                i3++;
            } else {
                i5++;
            }
            list.add(min);
        }
        return list.get(n);
    }
}
