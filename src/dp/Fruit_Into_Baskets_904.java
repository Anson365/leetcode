package dp;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/16/18.
 */
public class Fruit_Into_Baskets_904 {
    public int totalFruit(int[] tree) {
        int index = -1, max = 1, temp = 1;
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == tree[i-1]) {
                temp++;
            } else {
                if (index < 0) {
                    index = i;
                    temp++;
                } else {
                    if (tree[i] == tree[index - 1]) {
                        temp++;
                        index = i;
                    } else {
                        max = Math.max(max, temp);
                        temp = i - index + 1;
                        index = i;
                    }
                }
            }

        }
        return Math.max(max, temp);
    }
//    public static void main(String[] args) {
//        Fruit_Into_Baskets_904 fruit_into_baskets_904 = new Fruit_Into_Baskets_904();
//        int[] temp = {0,1,2,2};
//        fruit_into_baskets_904.totalFruit(temp);
//    }
}
