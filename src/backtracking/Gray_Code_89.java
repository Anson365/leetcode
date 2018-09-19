package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/19/18.
 */
public class Gray_Code_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        } else {
            int base = (int)Math.pow(2, n - 1);
            List<Integer> pre = grayCode(n - 1);
            result.addAll(pre);
            for (int i = base - 1; i >= 0; i--) {
                result.add(pre.get(i) + base);
            }
            return result;
        }
    }
}
