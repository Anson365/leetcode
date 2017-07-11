package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/7/11.
 */
public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        int[] factors = new int[n+1];
        factors[0] = 1;
        for (int i=1;i<=n;i++)
            factors[i] = i * factors[i - 1];

        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++)
            list.add(i);
        k--;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=n;i>0;i--){
            int index = k/factors[i-1];
            stringBuilder.append(list.get(index));
            list.remove(index);
            k=k%factors[i-1];
        }
        return stringBuilder.toString();
    }
}
