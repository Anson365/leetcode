package contest.contest_143;

/**
 * @author luodaihua
 * Created on 2019-06-30
 */
public class Distribute_Candies_to_People_1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int tmp = 1;
        int index = 0;
        while (tmp <= candies) {
            result[index % num_people] += tmp;
            candies -= tmp;
            tmp++;
            index++;
        }
        result[index % num_people] += candies;
        return result;
    }
}
