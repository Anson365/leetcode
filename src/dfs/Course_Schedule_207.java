package dfs;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/25/18.
 */
public class Course_Schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> courseSet = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] temp = prerequisites[i];
            map.put(temp[0], temp[1]);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> set = new HashSet<>();
            int[] temp = prerequisites[i];
            int start = temp[0];
            int end = temp[1];
            if (set.contains(start)) {
                continue;
            }
            set.add(start);
            courseSet.add(start);
            while (map.get(end) != null) {
                int tempStart = map.get(end);
                if (set.contains(tempStart)) {
                    return false;
                }
                courseSet.add(tempStart);
                set.add(tempStart);
                end = tempStart;
            }
        }
        return courseSet.size() <= numCourses;
    }

//    public static void main(String[] args) {
//        int[][] temp = {{1,0},{2,0},{0,2}};
//        int num = 3;
//        Course_Schedule_207 course_schedule_207 = new Course_Schedule_207();
//        course_schedule_207.canFinish(3, temp);
//    }
}
