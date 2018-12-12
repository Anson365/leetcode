package design.queue;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/12/18.
 */
public class Design_Circular_Queue_622 {
    private int[] array;
    private int start = 0,end = 0, count = 0;
    private static Integer MAX;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public Design_Circular_Queue_622(int k) {
        MAX = k;
        array = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (count == MAX) {
            return false;
        }
        if (count == 0) {
            array[end] = value;
        } else {
            end = (end + 1) % MAX;
            array[end] = value;
        }
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        if (count != 1) {
            start = (start + 1) % MAX;
        }
        count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (count == 0) {
            return -1;
        }
        return array[start];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return array[end];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == MAX;
    }
}
