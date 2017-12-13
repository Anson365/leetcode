package sort;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/13.
 */
public class Helper {
    public static void swap(int[] array,int sourceIndex,int targetIndex){
        int temp = array[sourceIndex];
        array[sourceIndex] = array[targetIndex];
        array[targetIndex] = temp;
    }
    public static boolean ordered(int[] array){
        boolean ordered = true;
        int i=1;
        while (ordered&&i<array.length){
            ordered = array[i]>=array[i-1];
            i++;
        }
        Arrays.stream(array).forEach(item
                ->System.out.println(item));
        return ordered;
    }
}
