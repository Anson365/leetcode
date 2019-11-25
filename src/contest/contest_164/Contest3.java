package contest.contest_164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anson
 * Created on 2019-11-24
 */
class Contest3 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        List<String> productsList = Arrays.stream(products).sorted().collect(Collectors.toList());
        for (int i = 0; i < searchWord.length(); i++) {
            if (productsList.size() == 0) {
                result.add(new ArrayList<>());
                continue;
            }
            final int tmpIndex = i;
            char tmp = searchWord.charAt(i);
            productsList = productsList.stream().filter(t -> t.length() > tmpIndex && t.charAt(tmpIndex) == tmp).collect(Collectors.toList());
            if (productsList.size() <= 3) {
                result.add(productsList);
            } else {
                result.add(productsList.subList(0, 3));
            }
        }
        return result;
    }
}
