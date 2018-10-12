package array;

import java.util.Arrays;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/12/18.
 */
public class Task_Scheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        for (char c : tasks) {
            int index = c - 'A';
            temp[index] += 1;
        }
        Arrays.sort(temp);
        int count = 0, i = 25;
        while (temp[i] == temp[25]) {
            i--;
            count++;
        }
        return Math.max(tasks.length, (temp[25] - 1) * (n + 1) + count);
    }
}
