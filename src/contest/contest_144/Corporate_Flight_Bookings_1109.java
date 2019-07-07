package contest.contest_144;

/**
 * @author luodaihua
 * Created on 2019-07-07
 */
public class Corporate_Flight_Bookings_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            result[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                result[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }

    public int[] corpFlightBookings_1(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int count = booking[2];
            for (int i = start; i <= end; i++) {
                result[i - 1] += count;
            }
        }
        return result;
    }
}
