package contest.contest_149;

import java.util.Arrays;

/**
 * @author luodaihua
 * Created on 2019-08-11
 */
class Contest1 {

    private int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        int[] dateArray = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
        int moth = dateArray[1];
        if (moth <= 2) {
            return days[dateArray[1] - 1] + dateArray[2];
        }
        int year = dateArray[0];
        int feb = 0;
        if (year % 100 == 0) {
            feb = year % 400 == 0 ? 29 : 28;
        } else {
            feb = year % 4 == 0 ? 29 : 28;
        }
        int res = 0;
        for (int i = 0; i < moth; i++) {
            if (i == 2) {
                res += feb;
            } else {
                res += days[i];
            }
        }
        return res + dateArray[2];
    }
}
