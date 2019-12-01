package contest.contest_165;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anson
 * Created on 2019-12-01
 */
class Contest1 {
    public String tictactoe(int[][] moves) {
        List<String>[] row = new ArrayList[3];
        List<String>[] column = new ArrayList[3];
        List<String> xy = new ArrayList<>();
        List<String> yx = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            String tempStep = i % 2 == 0 ? "X" : "Y";
            int[] move = moves[i];
            int x = move[0];
            int y = move[1];
            List<String> tempX = row[x];
            if (tempX == null) {
                tempX = new ArrayList<>();
            }
            tempX.add(tempStep);
            List<String> tempY = column[y];
            if (tempY == null) {
                tempY = new ArrayList<>();
            }
            tempY.add(tempStep);
            if (x == y) {
                xy.add(tempStep);
            }
            if (x == 2 - y) {
                yx.add(tempStep);
            }
            row[x] = tempX;
            column[y] = tempY;
        }
        for (List<String> r : row) {
            if (r.size() < 3) {
                continue;
            }
            if (r.contains("X") && r.contains("Y")) {
                continue;
            }
            return r.contains("X") ? "A" : "B";
        }
        for (List<String> c : column) {
            if (c.size() < 3) {
                continue;
            }
            if (c.contains("X") && c.contains("Y")) {
                continue;
            }
            return c.contains("X") ? "A" : "B";
        }
        if (xy.size() == 3) {
            if (!xy.contains("X") || !xy.contains("Y")) {
                return xy.contains("X") ? "A" : "B";
            }
        }
        if (yx.size() == 3) {
            if (!yx.contains("X") || !yx.contains("Y")) {
                return yx.contains("X") ? "A" : "B";
            }
        }
        if(moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }
}
