package contest.contest_158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Contest2 {
    private int[][] direction = new int[][] {{0, -1}, {1, -1}, {1, 0}, {1,1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> queenSet = Arrays.stream(queens).map(t -> t[0] + "_" + t[1]).collect(Collectors.toSet());
        for (int[] dir : direction) {
            int tempI = king[0] + dir[0];
            int tempJ = king[1] + dir[1];
            while (tempI >= 0 && tempI < 8 && tempJ >= 0 && tempJ < 8) {
                String temp = tempI + "_" + tempJ;
                if (queenSet.contains(temp)) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(tempI);
                    tempList.add(tempJ);
                    res.add(tempList);
                    break;
                } else {
                    tempI += dir[0];
                    tempJ += dir[1];
                }
            }
        }
        return res;
    }
}
