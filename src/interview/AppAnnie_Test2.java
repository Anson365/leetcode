package interview;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/12/18.
 */
public class AppAnnie_Test2 {

    public int solution(int[] A) {
        int count = 1;
        int pointer = A[0];
        while (pointer != -1) {
            pointer = A[pointer];
            count++;
        }
        return count;
    }
}
