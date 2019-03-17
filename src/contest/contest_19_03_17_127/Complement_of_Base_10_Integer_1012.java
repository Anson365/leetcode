package contest.contest_19_03_17_127;

/**
 * @author luodaihua
 * Created on 2019-03-17
 */
public class Complement_of_Base_10_Integer_1012 {
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }

    public int bitwiseComplement_1(int N) {
        String temp = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();
        for (char c : temp.toCharArray()) {
            if (c == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return Integer.valueOf(sb.toString(), 2);
    }
}
