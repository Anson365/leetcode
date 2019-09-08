package contest.contest_153;

/**
 * @author luodaihua
 * Created on 2019-09-08
 */
class Contest1 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int[] sum = new int[distance.length + 1];
        int temp = 0;
        for (int i = 1; i <= distance.length; i++) {
            temp += distance[i - 1];
            sum[i] = temp;
        }
        int tempStart = Math.min(start, destination);
        int tempDes = Math.max(start, destination);
        int res = Math.min(Math.abs(sum[tempDes] - sum[tempStart]), Math.abs(sum[distance.length] - sum[tempDes] + sum[tempStart]));
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest1 = new Contest1();
        contest1.distanceBetweenBusStops(new int[] {7,10,1,12,11,14,5,0}, 7, 2);
    }
}
