package twopointer;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ludao on 2017/7/18.
 */
public class SmallestRange_632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        //创建优先队列
        Queue<Element> pq = new PriorityQueue<Element>(nums.size(),new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val-o2.val;
            }
        });
        int max=Integer.MIN_VALUE;
        //每个行取一个元素 保证最小区间包含所有行元素
        for(int i=0;i<nums.size();i++){
            int val = nums.get(i).get(0);
            Element e = new Element(val,0,i);
            pq.offer(e);
            max = Math.max(max,val);
        }
        int range = Integer.MAX_VALUE;
        int start = -1,end = -1;
        while (pq.size() == nums.size()){
            //取出最小元素 比较新区间位置
            Element curr = pq.poll();
            if(max - curr.val < range){
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            //并挪动同行元素
            if(curr.idx + 1 < nums.get(curr.row).size()){
                curr.idx = curr.idx + 1;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if(curr.val > max){
                    max = curr.val;
                }
            }
        }
        return new int[] {start,end};

    }


    class Element{
        int val;
        int idx;
        int row;

        public Element(int val, int idx, int row) {
            this.val = val;
            this.idx = idx;
            this.row = row;
        }
    }
}
