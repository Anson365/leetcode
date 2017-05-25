package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ludao on 2017/4/20.
 */
public class FriendCircles_547 {
    public int findCircleNum(int[][] M) {
        Set<Integer> set = new HashSet<Integer>();
        int count=0;
        for(int i=0;i<M.length&&set.size()<M.length;i++){
            if(!set.contains(i)) {
                set.add(i);
                findCircle(M, i, set);
                count++;
            }
        }
        return count;
    }

    private void findCircle(int[][] M,int i,Set<Integer> set){
        int length = M.length;
        for(int j=0;j<length;j++){
            if(set.contains(j)&&set.contains(i)){
                continue;
            }
            if(M[i][j] == 1){
                set.add(j);
                findCircle(M, j, set);
            }
        }
    }

    public static void main(String[] args){
        FriendCircles_547 friendCircles_547 = new FriendCircles_547();
        int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int count = friendCircles_547.findCircleNum(M);
        return;
    }

}
