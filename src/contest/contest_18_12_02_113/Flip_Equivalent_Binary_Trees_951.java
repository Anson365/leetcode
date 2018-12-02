package contest.contest_18_12_02_113;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/1/18.
 */
public class Flip_Equivalent_Binary_Trees_951 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            list.addFirst(list.pollLast());
            list.addFirst(deck[i]);
        }
        return list.stream().mapToInt(item -> (int)item).toArray();
    }
}
