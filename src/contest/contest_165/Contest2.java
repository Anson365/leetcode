package contest.contest_165;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anson
 * Created on 2019-12-01
 */
class Contest2 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int temp = tomatoSlices - 2 * cheeseSlices;

        if (temp % 2 != 0 || temp < 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        result.add(temp / 2);
        if (cheeseSlices - temp/2 < 0) {
            return new ArrayList<>();
        }
        result.add(cheeseSlices - temp/2);
        return result;
    }
}
