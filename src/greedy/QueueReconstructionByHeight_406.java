package greedy;

import java.util.*;

/**
 * Created by ludao on 2017/3/30.
 */
public class QueueReconstructionByHeight_406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0||people[0].length==0){
            return new int[0][];
        }
        int length = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> temp = new LinkedList<int[]>();
        for(int i=0;i<length;i++){
            temp.add(people[i][1],people[i]);
        }
        return temp.toArray(new int[][]{});
    }


    public static void main(String[] args){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        QueueReconstructionByHeight_406 queueReconstructionByHeight_406 = new QueueReconstructionByHeight_406();
        int[][] result = queueReconstructionByHeight_406.reconstructQueue(people);
        return;
    }
}
