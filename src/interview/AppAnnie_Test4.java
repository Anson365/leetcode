package interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/19/18.
 */
public class AppAnnie_Test4 {
    public String solution(int N, String S, String T) {
        List<String> list = Arrays.stream(T.split(" ")).collect(Collectors.toList());
        Set<String> hitsMap = new HashSet<>(list);

        String[] ships = S.split(",");
        int hit = 0,sunk = 0;
        for (String ship : ships) {
            int temp = doJudge(ship, hitsMap);
            if (temp == 0) {
                sunk++;
            } else if (temp == 1) {
                hit++;
            }
        }
        return sunk + "," + hit;

    }

    private int doJudge(String ship, Set<String> hitsMap) {
        List<String> locations = getLocations(ship);
        int hitCount = 0;
        for (String location : locations) {
            if  (hitsMap.contains(location)) {
                hitCount++;
            }
        }
        if(hitCount == locations.size()) { //sunk
            return 0;
        } else if (hitCount < locations.size() && hitCount != 0) {//hit
            return 1;
        } else {
            return 2; // safe;
        }
    }

    private List<String> getLocations(String ship) {
        String[] locations = ship.split(" ");
        int rowTop = Integer.valueOf(locations[0].replaceAll("[A-Z]", ""));
        char columnTop = locations[0].charAt(locations[1].length() - 1);
        int rowBottom = Integer.valueOf(locations[0].replaceAll("[A-Z]", ""));
        char columnBottom = locations[1].charAt(locations[1].length() - 1);
        List<String> result = new ArrayList<>();
        for (int i = rowTop; i <= rowBottom; i++) {
            for (int j = columnTop; j <= columnBottom; j++) {
                StringBuilder temp = new StringBuilder();
                temp.append(i).append((char)j);
                result.add(temp.toString());
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        AppAnnie_Test4 appAnnie_test4 = new AppAnnie_Test4();
//        appAnnie_test4.solution(3, "1A 2A,12A 12A", "12A");
//    }
}
