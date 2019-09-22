package contest.contest_155;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @author luodaihua
 * Created on 2019-09-22
 */
public class Contest2 {

    public int nthUglyNumber(int n, int a, int b, int c) {
        List<Integer> temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        Collections.sort(temp);
        a = temp.get(0);
        b = temp.get(1);
        c = temp.get(2);

        int tempIndex = b / a;

        TreeSet<Long> next = new TreeSet<>();
        next.add((long) a);

        long cur = 0;
        for (int i = tempIndex; i < n; ++i) {
            cur = next.first();
            next.add(cur * a);
            next.add(cur * b);
            next.add(cur * c);
            next.remove(cur);
        }
        return (int) cur;
    }

    int getNthUglyNo(int n, int a, int b, int c) {
        List<Integer> temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        Collections.sort(temp);
        a = temp.get(0);
        b = temp.get(1);
        c = temp.get(2);

        int ugly[] = new int[n]; // To store ugly numbers 
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_a = a;
        int next_multiple_of_b = b;
        int next_multiple_of_c = c;
        int next_ugly_no = 1;

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_a,
                    Math.min(next_multiple_of_b, next_multiple_of_c));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_a) {
                i2 = i2 + 1;
                next_multiple_of_a = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_b) {
                i3 = i3 + 1;
                next_multiple_of_b = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_c) {
                i5 = i5 + 1;
                next_multiple_of_c = ugly[i5] * 5;
            }
        }
        return next_ugly_no;
    }

}
