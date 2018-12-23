package design.stack;

/**
 * Created by Anson on 2017/5/31.
 */
public class MinStack155 {
    private Integer min;
    private Entity top;

    public MinStack155() {}
    public void push(int x) {
        min = min==null||min>x?x:min;
        if(top == null){
            top = new Entity(x);
        }else {
            Entity temp = new Entity(x);
            temp.previews = top;
            top = temp;
        }
    }
    public void pop() {
        if(top != null){
            int temp = top.data;
            top = top.previews;
            if(temp==min) {
                findMin();
            }
        }else {
            throw new StackOverflowError();
        }
    }
    public int top() {
        if(top != null){
            return top.data;
        }else {
            throw new StackOverflowError();
        }
    }
    public int getMin() {
        return this.min;
    }
    private void findMin(){
        Entity temp = top;
        if(top == null){
            min = null;
            return;
        }
        min = top.data;
        while (temp.previews != null){
            Entity previews = temp.previews;
            min = min>previews.data?previews.data:min;
            temp = temp.previews;
        }
    }
    public class Entity{
        private int data;
        private Entity previews;
        public Entity(int x) {
            this.data = x;
        }
    }
//    public static void main(String[] args){
//        MinStack155 minStack = new MinStack155();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        int data1 = minStack.getMin();   //--> Returns -3.
//        minStack.pop();
//        int data2 = minStack.top();      //--> Returns 0.
//        int data3 = minStack.getMin();   //--> Returns -2.
//        System.out.print(true);
//    }
}
