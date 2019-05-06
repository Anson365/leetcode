package contest.contest_19_05_05_135;

/**
 * @author luodaihua
 * Created on 2019-05-05
 */
public class Valid_Boomerang_1037 {
    public boolean isBoomerang_2(int[][] points) {
        if (points[0][1] == points[1][1] && points[0][0] == points[0][1]) {
            return false;
        }
        if (points[0][1] == points[2][1] && points[0][0] ==  points[0][1]) {
            return false;
        }
        if (points[1][1] == points[2][1] && points[1][0] ==  points[2][1]) {
            return false;
        }
        double k1 = (points[0][1] - points[1][1]) * 1.0d / (points[0][0] -  points[0][1]);
        double k2 = (points[0][1] - points[2][1]) * 1.0d / (points[0][0] -  points[2][1]);
        double k3 = (points[1][1] - points[2][1]) * 1.0d / (points[1][0] -  points[2][1]);
        return k1 != k2 && k2 != k3 && k1 != k3;
    }

    public boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
}
