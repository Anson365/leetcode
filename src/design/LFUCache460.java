package design;

import java.util.*;

/**
 * Created by Anson on 2017/6/4.
 */
public class LFUCache460 {

    private int capacity = -1;
    private Map<Integer,Integer> key2Val ;
    private Map<Integer,Integer> key2Count ;
    private Map<Integer,LinkedList<Integer>> count2KeyList;

    public LFUCache460(int capacity) {
        this.capacity = capacity;
        key2Count = new HashMap<Integer,Integer>();
        key2Val = new HashMap<Integer,Integer>();
        count2KeyList = new HashMap<Integer,LinkedList<Integer>>();
    }

    public int get(int key) {
        if(!key2Val.containsKey(key)){
            return -1;
        }
        Integer currentCount = key2Count.get(key);
        key2Count.put(key,currentCount+1);
        count2KeyList.get(currentCount).removeFirstOccurrence(key);
        LinkedList<Integer> linkedList = count2KeyList.get(currentCount+1);
        if(linkedList == null){
            linkedList = new LinkedList<Integer>();
            count2KeyList.put(currentCount+1,linkedList);
        }
        linkedList.addFirst(key);
        return key2Val.get(key);
    }

    public void put(int key, int value) {
        if(capacity<1){
            return;
        }
        if(key2Val.containsKey(key)){
            key2Val.put(key,value);
            get(key);
            return;
        }
        if(key2Val.size()<capacity){
            key2Val.put(key,value);
            key2Count.put(key,1);
            LinkedList<Integer> linkedList = count2KeyList.get(1);
            if(linkedList == null){
                linkedList = new LinkedList<Integer>();
                count2KeyList.put(1,linkedList);
            }
            if(linkedList.contains(key)){
                linkedList.removeFirstOccurrence(key);
            }
            linkedList.addFirst(key);
        }else {
            for(int i=1;;i++){
                LinkedList<Integer> linkedList = count2KeyList.get(i);
                if(linkedList==null||!linkedList.isEmpty()){
                    Integer oldKey = linkedList.getLast();
                    linkedList.removeLast();
                    key2Val.remove(oldKey);
                    key2Count.remove(oldKey);
                    break;
                }
            }
            key2Val.put(key,value);
            key2Count.put(key,1);
            LinkedList<Integer> linkedList = count2KeyList.get(1);
            if(linkedList == null){
                linkedList = new LinkedList<Integer>();
                count2KeyList.put(1,linkedList);
            }
            linkedList.addFirst(key);
        }
    }

    public static void main(String[] args){
        LFUCache460 lfuCache460 = new LFUCache460(2);
//        [[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]

        lfuCache460.put(2,1);
        lfuCache460.put(2,2);
        int result1 = lfuCache460.get(2);
//        int result2 =lfuCache460.get(1);
//        int result3 =lfuCache460.get(2);
        lfuCache460.put(1,1);
        lfuCache460.put(4,1);
//        int result4 = lfuCache460.get(3);
        int result5 = lfuCache460.get(2);
//        int result6 = lfuCache460.get(1);
//        int result7 = lfuCache460.get(4);
        System.out.print(true);



    }

}
