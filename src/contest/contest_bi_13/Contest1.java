package contest.contest_bi_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Anson
 * Created on 2019-11-16
 */
class Contest1 {
    private Set<String> res = new HashSet<>();

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, String> map = synonyms.stream().collect(Collectors.toMap(t -> t.get(0), t -> t.get(1)));
        String[] array = text.split("\\s+");
        res.add(text);
        for (int i = 0; i < array.length; i++) {
            helper(Arrays.copyOf(array, array.length), i, map, new HashSet<>());
        }
        List<String> result = new ArrayList<>(res);
        result.sort(String::compareTo);
        return result;
    }

    private void helper(String[] array, int index, Map<String, String> map, Set<String> set) {
        if (index >= array.length) {
            return;
        }
        if (map.containsKey(array[index]) && !set.contains(map.get(array[index]))) {
            res.add(String.join(" ", array));
            array[index] = map.get(array[index]);
            res.add(String.join(" ", array));
            set.add(array[index]);
            helper(array, index, map, set);
        } else {
            helper(array, index + 1, map, new HashSet<>());
        }
    }

    public static void main(String[] args) {
        Contest1 contest1 = new Contest1();
        List<String> list = new ArrayList<>();
        list.add("happy");
        list.add("joy");
        List<List<String>> list1 = new ArrayList<>();
        list1.add(list);
        contest1.generateSentences(list1, "I am happy today but was sad yesterday");
    }
}
