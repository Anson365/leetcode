package dfs;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/6/18.
 */
public class Reconstruct_Itinerary_332 {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> roadMap = new HashMap<>();
        for (String[] ticket : tickets) {
            String dep = ticket[0];
            String arr = ticket[1];
            roadMap.computeIfAbsent(dep, k -> new PriorityQueue<>()).add(arr);
        }
        String startKey  = "JFK";
        dfs(roadMap, startKey, result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> roadMap, String startKey, List<String> result) {
        while (roadMap.containsKey(startKey) && !roadMap.get(startKey).isEmpty() ) {
            dfs(roadMap, roadMap.get(startKey).poll(), result);
        }
        result.add(0, startKey);
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        Reconstruct_Itinerary_332 reconstruct_itinerary_332 = new Reconstruct_Itinerary_332();
        reconstruct_itinerary_332.findItinerary(tickets);
    }
}
