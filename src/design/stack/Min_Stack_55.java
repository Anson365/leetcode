package design.stack;

/**
 * @author luodaihua
 * Created on 2019-07-18
 */
public class Min_Stack_55 {

    private int min;
    private int[] array;
    private int index;
    public Min_Stack_55() {
        array = new int[1000];
        min = Integer.MAX_VALUE;
        index = 0;
    }

    public void push(int x) {
        if (x <= min) {
            array[index++] = min;
            min = x;
        }
        array[index++] = x;

    }

    public void pop() {

        if (min == top()) {
            index--;
            min = array[--index];
        } else {
            index--;
        }

    }

    public int top() {
        return array[index - 1];
    }

    public int getMin() {

        return min;
    }

    public static void main(String[] args) {
        Min_Stack_55 min_stack_55 = new Min_Stack_55();
        min_stack_55.push(-2);
        min_stack_55.push(0);
        min_stack_55.push(-3);
        System.out.println(min_stack_55.getMin());
        min_stack_55.pop();
        System.out.println(min_stack_55.top());
        System.out.println(min_stack_55.getMin());

    }
}
