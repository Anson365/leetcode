package array;

/**
 * Created by Anson on 12/17/18.
 */
public class Set_Matrix_Zeroes_73 {
    public void setZeroes(int[][] matrix) {
        boolean firstRowsHasZero = false, firstColumnHasZero = false;
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == 0) {
                firstRowsHasZero = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < column; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstRowsHasZero) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Set_Matrix_Zeroes_73 set_matrix_zeroes_73 = new Set_Matrix_Zeroes_73();
        int[][] temp = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        set_matrix_zeroes_73.setZeroes(temp);
    }
}
