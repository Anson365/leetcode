package contest.contest_151;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author luodaihua
 * Created on 2019-08-25
 */
class Contest4 {
    List<Stack<Integer>> list;
    private int capacity;
    public Contest4(int capacity) {
        list = new ArrayList<>();
        this.capacity = capacity;
    }

    public void push(int val) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() < capacity) {
                list.get(i).push(val);
                return;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(val);
        list.add(stack);
    }

    public int pop() {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).size() > 0) {
                return list.get(i).pop();
            }
        }
        return -1;
    }

    public int popAtStack(int index) {
        if (list.get(index).size() > 0) {
            return list.get(index).pop();
        }
        return -1;
    }

    public static void main(String[] args) {
        Contest4 contest4 = new Contest4(2);
        contest4.push(1);
        contest4.push(2);
        contest4.push(3);
        contest4.push(4);
        contest4.push(5);
        contest4.popAtStack(0);





    }
}
