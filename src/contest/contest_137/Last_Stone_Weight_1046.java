package contest.contest_137;

/**
 * @author luodaihua
 * Created on 2019-05-19
 */
public class Last_Stone_Weight_1046 {

    public int lastStoneWeight(int[] stones) {
        int[] tmp = new int[1001];
        for (int stone : stones) {
            tmp[stone]++;
        }
        int bigger = 0;
        for (int i = 1000; i > 0; i--) {
            if (tmp[i] != 0) {
                if (bigger == 0) {
                    bigger = i;
                    tmp[i]--;
                    i++;
                } else {
                    tmp[bigger - i]++;
                    int tempIndex;
                    if (bigger - i > i) {
                        tempIndex = bigger - i + 1;
                    } else {
                        tempIndex = i + 1;
                    }
                    bigger = 0;
                    tmp[i]--;
                    i = tempIndex;
                }
            }
        }
        return bigger;
    }

    public static void main(String[] args) {
        Last_Stone_Weight_1046 lastStoneWeight1046 = new Last_Stone_Weight_1046();
        lastStoneWeight1046.lastStoneWeight(new int[] {1,3});
    }
}
