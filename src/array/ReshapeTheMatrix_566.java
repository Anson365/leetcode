package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 17/7/27.
 */
public class ReshapeTheMatrix_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if(row*column<r*c)
            return nums;
        int[][] result = new int[r][c];
        int tempR = 0,tempC = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(tempC<column&&tempR<row){
                    result[i][j] = nums[tempR][tempC];
                    if(tempC+1>=column){
                        tempR++;
                        tempC=-1;
                    }
                    if(tempR>=row){
                        return result;
                    }
                    tempC++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        ReshapeTheMatrix_566 reshapeTheMatrix_566 = new ReshapeTheMatrix_566();
        int[][] metrix = {{1,2},{3,4}};

        reshapeTheMatrix_566.matrixReshape(metrix,1,4);
    }
}
