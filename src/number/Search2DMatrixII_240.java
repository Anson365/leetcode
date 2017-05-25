package number;

/**
 * Created by ludao on 2017/3/16.
 */
public class Search2DMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int rowMax = matrix.length-1;
        int columnMax = matrix[0].length-1;
        int rowIndex=0,columnIndex=0;
        while(true){
            if(matrix[rowIndex][columnIndex]==target){//find the target
                return true;
            }
            if(matrix[rowIndex][columnIndex]>target){//target is in the row or column;
                break;
            }
            if(columnIndex==columnMax&&rowIndex==rowMax){
                return false;
            }
            rowIndex = rowIndex>=rowMax?rowMax:++rowIndex;
            columnIndex = columnIndex>=columnMax?columnIndex:++columnIndex;
        }
        for(int i=0;i<(rowIndex);i++){
            if(matrix[i][columnIndex]==target){
                return true;
            }
        }
        for(int i=0;i<(columnIndex);i++){
            if(matrix[rowIndex][i]==target){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int target = 15;
        Search2DMatrixII_240 search2DMatrixII_240 = new Search2DMatrixII_240();
        Boolean result = search2DMatrixII_240.searchMatrix(matrix,target);
        int i= 0;
    }
}
