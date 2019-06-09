package contest.contest_140;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodaihua
 * Created on 2019-06-09
 */
public class Occurrences_After_Bigram_5083 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] temp = text.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < temp.length - 2; i++) {
            if (first.equals(temp[i]) && second.equals(temp[i + 1])) {
                result.add(temp[i + 2]);
            }
        }
        return result.stream().toArray(String[]::new);
    }
}
