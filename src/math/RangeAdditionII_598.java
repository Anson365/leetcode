package math;

/**
 * Created by ludao on 2017/6/26.
 */
public class RangeAdditionII_598 {
    public int maxCount(int m, int n, int[][] ops) {
        int row = ops.length;
        int minRow=m,minColumn=n;
        for(int i=0;i<row;i++){
            int a = ops[i][0];
            int b = ops[i][1];
            minRow = Math.min(a,minRow);
            minColumn = Math.min(b,minColumn);
        }
        return minColumn*minRow;
    }
}
