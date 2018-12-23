package others;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 8/29/18.
 */
public class Elimination_Game_390 {
    public int lastRemaining(int n) {
        int step = 1;
        int remaining = n;
        int head = 1;
        boolean startFromLeft = true;
        while (remaining / 2 != 0) {
            if (startFromLeft) {
                head += step;
            } else {
                if (remaining % 2 == 1) {
                    head += step;
                }
            }
            step *= 2;
            remaining /= 2;
            startFromLeft = !startFromLeft;
        }
        return head;
    }

//    public static void main(String[] args) {
//        Elimination_Game_390 elimination_game_390 = new Elimination_Game_390();
//        elimination_game_390.lastRemaining(10);
//    }
}
