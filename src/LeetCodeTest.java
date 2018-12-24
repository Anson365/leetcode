/**
 * Created by ludao on 2017/6/9.
 */
public class LeetCodeTest {
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length==0||array[0].length==0){
            return false;
        }
        int row = array.length;
        int column = array[0].length;
        int min = array[0][0];
        int max = array[row-1][column-1];
        if(target<min||target>max){
            return false;
        }
        return helper(target,array,0,0,row-1,column-1);


    }

    public boolean helper(int target,int[][] array,int startRow,int startColumn,int endRow,int endColumn){
        if(endRow<startRow||endColumn<startColumn){
            return false;
        }
        if(endRow==startRow&&endColumn==startColumn){
            return array[startRow][startColumn] == target;
        }
        int midleRow = startRow + (endRow-startRow)/2;
        int midleColumn = startColumn + (endColumn-startColumn)/2;
        int temp = array[midleRow][midleColumn];
        if(target==temp){
            return true;
        }
        if(target<temp){
            return helper(target,array,startRow,startColumn,midleRow,midleColumn);
        }else{
            boolean result1 = helper(target,array,midleRow+1,startColumn,endRow,midleColumn);
            boolean result2 = helper(target,array,midleRow+1,midleColumn+1,endRow,endColumn);
            boolean result3 = helper(target,array,startRow,midleColumn+1,midleRow,endColumn);
            return result1||result2||result3;
        }

    }


//    public static void main(String[] args){
//        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int target = 7;
//        LeetCodeTest leetCodeTest = new LeetCodeTest();
//        Boolean result = leetCodeTest.Find(7,array);
//        System.out.print(true);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        if(stringBuilder!=null) {
//            stringBuilder.toString().replaceAll("\\s", "%20");
//        }
//    }
}
