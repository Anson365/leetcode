package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ludao on 2017/4/12.
 */
public class Matrix01_542 {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(matrix==null||matrix.size()==0){
            return new ArrayList<List<Integer>>();
        }
        int row = matrix.size();
        int column = matrix.get(0).size();
        int[][] temp = new int[row][column];
        for(int i = 0;i<row;i ++ ){
            List<Integer> columnList = matrix.get(i);
            for(int j=0;j<column;j++){
                int ele = columnList.get(j);
                if(ele!=0){
                    int left = j-1>=0?temp[i][j-1]:Integer.MAX_VALUE-1;
                    int top = i-1>=0?temp[i-1][j]:Integer.MAX_VALUE-1;
                    ele = Math.min(Integer.MAX_VALUE-1,Math.min(left+1,top+1));
                }
                temp[i][j]=ele;
            }
        }
        for(int i = row - 1;i>-1;i -- ){
            List<Integer> columnList = matrix.get(i);
            for(int j=column - 1;j>-1;j--){
                int ele = columnList.get(j);
                if(ele!=0){
                    int left = j+1<column?temp[i][j+1]:Integer.MAX_VALUE-1;
                    int top = i+1<row?temp[i+1][j]:Integer.MAX_VALUE-1;
                    ele = Math.min(temp[i][j],Math.min(left+1,top+1));
                }
                temp[i][j]=ele;
            }
        }
        for(int i=0;i<row;i++){
            List<Integer> rowList = new ArrayList<Integer>();
            for(int j=0;j<column;j++){
                rowList.add(temp[i][j]);
            }
            result.add(rowList);
        }
        return result;
    }
}
