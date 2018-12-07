/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/7/18.
 */
public class MinimumVSum {

    public int find(int[] array) {
        int sum = 0, _2sum = 0;
        for (int temp : array) {
            sum += temp;
            _2sum += temp * temp;
        }
        int result = 0, leftSum = 0, left2Sum = 0;
        float min = Float.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            leftSum = leftSum + array[i];
            int right = sum - leftSum;
            left2Sum = left2Sum + array[i] * array[i];
            int right2 = _2sum - left2Sum;
            float leftN = (i + 1) * 1.0f;
            float rightN = (array.length - i - 1) * 1.0f;
            float leftM = leftSum / leftN;
            float rightM = right / rightN;
            float leftVariance = left2Sum / leftN - leftM * leftM;
            float rightVariance = right2 / rightN - rightM * rightM;
            if (leftVariance + rightVariance < min) {
                min = leftVariance + rightVariance;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumVSum minimumVSum = new MinimumVSum();
        minimumVSum.find(new int[]{1,2,3});
    }
}
