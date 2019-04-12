package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luodaihua
 * Created on 2019-04-02
 */
public class Word_Pattern_290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        Map<Character, String> p2StrMap = new HashMap<>();
        Map<String, Character> str2PMap = new HashMap<>();
        if (strArray.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            String tempStr = strArray[i];
            if (p2StrMap.containsKey(temp) && !p2StrMap.get(temp).equals(tempStr)) {
                return false;
            }
            if (str2PMap.containsKey(tempStr) && !str2PMap.get(tempStr).equals(temp)) {
                return false;
            }
            p2StrMap.put(temp, tempStr);
            str2PMap.put(tempStr, temp);
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        for (long i = 6541367000L; i < 6541367999L; i++) {
            int temp = (int) Math.sqrt(i);
            for (int j = 2; j <= temp; j++) {
                if (i % j == 0 && isPrime(j) && isPrime((int) (i / j))) {
                    System.out.println(String.format("%d = %d x %d", i, j, i/j));
                    count++;
                }
            }
        }
        System.out.println("total count: " + count);

    }


    public static boolean isPrime(int n)

    {

        if(n < 2) return false;

        if(n == 2) return true;

        if(n%2==0) return false;

        for(int i = 3; i*i <= n; i += 2)

            if(n%i == 0) return false;

        return true;

    }



}
