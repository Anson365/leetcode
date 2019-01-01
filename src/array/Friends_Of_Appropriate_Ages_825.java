package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anson on 1/1/19.
 */
public class Friends_Of_Appropriate_Ages_825 {
    public int numFriendRequests(int[] ages) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int age : ages) {
            map.put(age, map.getOrDefault(age, 0) + 1);
        }

        for (Integer age1 : map.keySet()) {
            for (Integer age2 : map.keySet()) {
                if (!(age1 <= age2 * 0.5 + 7 || age1 > age2 || (age2 > 100 && age1 < 100))) {
                    int age1Count = map.get(age1), age2Count = map.get(age2);
                    if (age1 == age2) {
                        result += age1Count * (age2Count - 1);
                    } else {
                        result += age1Count * age2Count;
                    }
                }
            }
        }
        return result;
    }
}
