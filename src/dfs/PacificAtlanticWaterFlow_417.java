package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludao on 2017/7/19.
 */
public class PacificAtlanticWaterFlow_417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<int[]>();
        if(matrix==null||matrix.length==0){
            return list;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        Boolean[][] toP = new Boolean[row][column];
        Boolean[][] toA = new Boolean[row][column];
        for(int i=0;i<row;i++){
            toP[i][0] = true;
            toA[i][column-1] = true;
            helper(toP,matrix,i,0);
            helper(toA,matrix,i,column-1);
        }

        for(int i=0;i<column;i++){
            toP[0][i] = true;
            toA[row-1][i] = true;
            helper(toP,matrix,0,i);
            helper(toA,matrix,row-1,i);
        }


        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                Boolean tempA = toA[i][j];
                Boolean tempB = toP[i][j];
                if(tempA!=null&&tempB!=null&&tempA&&tempB){
                    list.add(new int[]{i,j});
                }
            }
        }
        return list;

    }

    private void helper(Boolean[][] flag,int[][] matrix,int row,int column){
        int rowMax = matrix.length;
        int columnMax = matrix[0].length;
        int current = matrix[row][column];
        //up
        if(row-1>=0&&flag[row-1][column]==null){
            int temp = matrix[row-1][column];
            if(temp>=current){
                flag[row-1][column] = true;
                helper(flag,matrix,row-1,column);
            }
        }
        //down
        if(row+1<rowMax&&flag[row+1][column]==null){
            int temp = matrix[row+1][column];
            if(temp>=current){
                flag[row+1][column] = true;
                helper(flag,matrix,row+1,column);
            }
        }
        //left
        if(column-1>=0&&flag[row][column-1]==null){
            int temp = matrix[row][column-1];
            if(temp>=current){
                flag[row][column-1] = true;
                helper(flag,matrix,row,column-1);
            }
        }
        //right
        if(column+1<columnMax&&flag[row][column+1]==null){
            int temp = matrix[row][column+1];
            if(temp>=current){
                flag[row][column+1] = true;
                helper(flag,matrix,row,column+1);
            }
        }

    }

    public static void main(String[] args){
//        int[][] matrix={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] matrix={{1,1},{1,1}};
        PacificAtlanticWaterFlow_417 pacificAtlanticWaterFlow_417
                 = new PacificAtlanticWaterFlow_417();
        pacificAtlanticWaterFlow_417.pacificAtlantic(matrix);

    }
}
