package interview.array;

/**
 * Created by ludao on 2017/6/11.
 */
public class PrintArrayInDiagonalDLine {

    public void doPrint(int[][] array,int n){
        for(int i=n-1;i>=0;i--){
            for(int j=0;j+i<n;j++){
                System.out.print(array[j][j+i]+",");
            }
            System.out.println();
        }

        for(int i=1;i<n;i++){
            for(int j=0;j+i<n;j++){
                System.out.print(array[j+i][j]+",");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args){
//        int[][] array = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//        PrintArrayInDiagonalDLine printArrayInDiagonalDLine = new PrintArrayInDiagonalDLine();
//        printArrayInDiagonalDLine.doPrint(array,5);
//    }
}
