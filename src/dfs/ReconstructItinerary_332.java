package dfs;

import java.util.*;

/**
 * Created by ludao on 2017/4/21.
 */
public class ReconstructItinerary_332 {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        Map<String,Queue<String[]>> map = new HashMap<String,Queue<String[]>>();
        for(String[] ticket:tickets){
            String from = ticket[0];
            Queue<String[]> queue = map.get(from);
            if(queue==null){
                queue = new PriorityQueue<String[]>(10, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return o1[1].compareTo(o2[1]);
                    }
                });
                map.put(from,queue);
            }
            queue.offer(ticket);

        }
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while (!stack.isEmpty()){
            Queue<String[]> queue = map.get(stack.peek());
            if(queue==null||queue.isEmpty()){
                result.add(0,stack.pop());
            }else {
                String to = queue.poll()[1];
                stack.push(to);
            }
        }
        return result;
    }


//    public static void main(String[] args){
//        String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
//        List<String> result = new ReconstructItinerary_332().findItinerary(tickets);
//        return;
//    }
}
