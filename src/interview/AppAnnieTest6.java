package interview;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/11/18.
 */
public class AppAnnieTest6 {
    private int max = 0;
    public int solution(String[] B) {
        // write your code in Java SE 8
        int row = B.length, column = B[0].length();
        int x = 0, y = 0;
        for (int i = 0; i < B.length; i++) {
            String temp = B[i];
            if (temp.contains("O")) {
                x = temp.indexOf("O");
                y = i;
                break;
            }
        }
        if (y < 1) {
            return max;
        }
        doJudge(x, y, B, 0);
        return max;
    }

    private void doJudge(int x, int y, String[] B, int count) {
        if (y < 2) {
            max = Math.max(max, count);
            return;
        }
        String tempStr = B[y - 1];
        if (x - 1 > 0 && tempStr.charAt(x - 1) == 'X') {
            String tempStr2 = B[y - 2];
            if (tempStr2.charAt(x - 2) != 'X') {
                doJudge(x - 2, y - 2, B, count + 1);
            }
        }
        if (x + 1 < tempStr.length() - 1 && tempStr.charAt(x + 1) == 'X') {
            String tempStr2 = B[y - 2];
            if (tempStr2.charAt(x + 2) != 'X') {
                doJudge(x + 2, y - 2, B, count + 1);
            }
        }
        max = Math.max(max, count);
    }

    public static void main(String[] args) {
        AppAnnieTest6 appAnnieTest6 = new AppAnnieTest6();
        appAnnieTest6.solution(new String[] {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."});
    }

}
