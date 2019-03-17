package contest.contest_19_03_17_127;

/**
 * @author luodaihua
 * Created on 2019-03-17
 */
public class Capacity_To_Ship_Packages_Within_D_Days_1014 {
    public int shipWithinDays_1(int[] weights, int D) {
        int sum = 0, max = 0;
        for (int weight : weights) {
            max = Math.max(weight, max);
            sum += weight;
        }
        if (D >= weights.length) {
            return max;
        }
        int average = sum % D == 0 ? (sum / D) : (sum / D + 1);
        int target = Math.max(average, max);
        while (!helper(target, weights, D)) {
            target++;
        }
        return target;
    }


    private boolean helper (int target, int[] weights, int D) {
        int i = 0, d = 0, tempSum = 0;
        while (i < weights.length && d < D) {
            tempSum += weights[i];
            if (tempSum <= target) {
                i++;
                continue;
            } else {
                d++;
                tempSum = 0;
            }
        }
        return d <= D && i == weights.length;
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
