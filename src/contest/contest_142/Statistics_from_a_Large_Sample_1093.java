package contest.contest_142;

/**
 * @author luodaihua
 * Created on 2019-06-23
 */
public class Statistics_from_a_Large_Sample_1093 {
    public double[] sampleStats(int[] count) {
        int modCount = 0;
        int mod = 0;
        double sum = 0;
        int num = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (count[i] > modCount) {
                mod = i;
                modCount = count[i];
            }
            sum += i * count[i];
            num += count[i];
            min = Math.min(min, i);
            max = i;
        }
        double mean = sum / num;
        double median = 0;
        if (num % 2 != 0) {
            int index = (num + 1) / 2;
            int tempNum = 0;
            for (int i = 0; i < count.length; i++) {
                tempNum += count[i];
                if (tempNum < index) {
                    continue;
                }
                median = i;
                break;
            }
        } else {
            int firstIndex = num / 2;
            int secondIndex = num / 2 + 1;
            int tempNum = 0;
            int firstValue = 0;
            int secondValue = 0;
            for (int i = 0; i < count.length; i++) {
                tempNum += count[i];
                if (tempNum < firstIndex) {
                    continue;
                }
                if (tempNum >= firstIndex) {
                    if (firstValue == 0) {
                        firstValue = i;
                    }
                }
                if (secondIndex <= tempNum) {
                    if (tempNum < secondIndex) {
                        if (firstValue != 0) {
                            continue;
                        }
                        firstValue = i;
                    } else {
                        if (firstValue == 0) {
                            firstValue = i;
                        }
                        secondValue = i;
                        break;
                    }
                }
            }
            median = (firstValue + secondValue) * 1.0d / 2;
        }

        return new double[] {min, max, mean, median, mod};
    }
}
