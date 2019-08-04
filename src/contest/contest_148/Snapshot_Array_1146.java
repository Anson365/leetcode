package contest.contest_148;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author luodaihua
 * Created on 2019-08-04
 */
public class Snapshot_Array_1146 {

    Temp[] array;
    private int snapId = 0;
    public Snapshot_Array_1146(int length) {
        array = new Temp[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Temp();
        }
    }

    public void set(int index, int val) {
        array[index].setHistory(val, snapId);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return array[index].getHistory(snapId);
    }


    private static class Temp {
        TreeMap<Integer, Integer> history = new TreeMap<>();

        public int getHistory(int snapId) {
            Map.Entry<Integer, Integer> entry = history.floorEntry(snapId);
            if (entry == null) {
                return 0;
            }
            return entry.getValue();
        }

        public void setHistory(int val, int snapId) {
            history.put(snapId, val);
        }
    }

    public static void main(String[] args) {
        Snapshot_Array_1146 snapshotArray1146 = new Snapshot_Array_1146(1);
        snapshotArray1146.set(0, 15);
        snapshotArray1146.snap();
        snapshotArray1146.snap();
        snapshotArray1146.snap();
        snapshotArray1146.get(0,3);
        snapshotArray1146.snap();
        snapshotArray1146.snap();
        snapshotArray1146.get(0, 0);
    }
}
