package toutiao;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/15/18.
 */
public class ThreadPrint {
    private static AtomicInteger num = new AtomicInteger(0);
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        ThreadPrint threadPrint = new ThreadPrint();
        new Thread(new Worker(0, 3)).start();
        new Thread(new Worker(1, 3)).start();
        new Thread(new Worker(2, 3)).start();
        countDownLatch.await();
        System.out.println("end");
    }
    static class Worker implements Runnable {
        private int next;
        private int step;
        private String threadName;
        public Worker(int next, int step) {
            this.next = next;
            this.step = step;
            this.threadName = "Thread-" + next;
        }
        @Override
        public void run() {
            while (true) {
                if (num.compareAndSet(next, next + 1)) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + ":" + next);
                    next += step;
                    if (next > 100) {
                        countDownLatch.countDown();
                        break;
                    }
                }
            }
        }
    }
}
