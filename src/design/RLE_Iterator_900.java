package design;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/9/18.
 */
public class RLE_Iterator_900 {
    private Queue<Constructor> queue = new ArrayDeque<>();

    public RLE_Iterator_900(int[] A) {
        int length = A.length;
        for(int i = 0; 2 * i < length; i++) {
            int repeat = A[2 * i], value = A[2 * i + 1];
            Constructor constructor = new Constructor(repeat, value);
            queue.add(constructor);
        }
    }

    public int next(int n) {
        if (queue.isEmpty()) {
            return -1;
        }
        Constructor constructor = queue.peek();
        int repeat = constructor.getRepeat();
        int value = constructor.getValue();
        if (n > repeat) {
            n = n - repeat;
            queue.poll();
            return next(n);
        } else {
            int remaining = repeat - n;
            if (remaining > 0) {
                constructor = new Constructor(remaining, value);
                queue.poll();
                ((ArrayDeque) queue).addFirst(constructor);
            } else {
                queue.poll();
            }
            return value;
        }

    }

    public static void main(String[] args) {
        int[] A = {3,8,0,9,2,5};
        RLE_Iterator_900 rle_iterator_900 = new RLE_Iterator_900(A);
        int temp = rle_iterator_900.next(2);
        int temp1 = rle_iterator_900.next(2);
    }

    class Constructor {
        private int repeat;
        private int value;

        public Constructor(int repeat, int value) {
            this.repeat = repeat;
            this.value = value;
        }

        public int getRepeat() {
            return repeat;
        }

        public void setRepeat(int repeat) {
            this.repeat = repeat;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
