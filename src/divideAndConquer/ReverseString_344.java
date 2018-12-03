package divideAndConquer;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/3/18.
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length/2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return new String(array);
    }
}
