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

}
