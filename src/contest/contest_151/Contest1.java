package contest.contest_151;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author luodaihua
 * Created on 2019-08-25
 */
class Contest1 {
    public List<String> invalidTransactions(String[] transactions) {
        Set<String> result = new HashSet<>();
        Map<String, PriorityQueue<Temp>> map = new HashMap<>();
        for (String t : transactions) {
            Temp temp = new Temp(t);
            PriorityQueue<Temp> priorityQueue = map.getOrDefault(temp.name, new PriorityQueue<Temp>((t1, t2) -> t1.time - t2.time));
            priorityQueue.add(temp);
            map.put(temp.name, priorityQueue);
        }
        for (Map.Entry<String, PriorityQueue<Temp>> entry : map.entrySet()) {
            PriorityQueue<Temp> tempQueue = entry.getValue();
            Temp indexTemp = tempQueue.poll();
            if (indexTemp.amount > 1000) {
                result.add(indexTemp.toString());
                continue;
            }
            List<Temp> list = new ArrayList<>();
            list.add(indexTemp);
            while (!tempQueue.isEmpty()) {
                Temp temp = tempQueue.poll();
                if (temp.amount > 1000) {
                    result.add(temp.toString());
                } else {
                    for (Temp temp1 : list) {
                        if (!temp1.city.equals(temp.city)) {
                            if (temp.time - temp1.time < 60) {
                                result.add(temp.toString());
                                result.add(temp1.toString());
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    static class Temp {
        String name;
        int time;
        int amount;
        String city;

        public Temp(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        public Temp(String tmp) {
            String[] str = tmp.split(",");
            this.name = str[0];
            this.time = Integer.valueOf(str[1]);
            this.amount = Integer.valueOf(str[2]);
            this.city = str[3];
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }
}
