package contest.contest_158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Contest2 {
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

    public static void main(String[] args) {
        int[][] queen = new int[][] {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        int[] king = new int[]{3,4};
        Contest2 contest2 = new Contest2();
        contest2.queensAttacktheKing(queen, king);
    }
}
