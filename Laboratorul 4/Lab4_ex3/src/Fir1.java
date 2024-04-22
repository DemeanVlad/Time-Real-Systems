import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;



public class Fir1 extends Thread {

    CountDownLatch countDownLatch;

    Semaphore s, s1;
    int activity_max, activity_min, sleep;

    public Fir1(Semaphore s, Semaphore s1, int min_activity, int max_activity, int sleep, int countDownLatch) {
        this.s = s;
        this.s1 = s1;
        this.activity_max = max_activity;
        this.activity_min = min_activity;
        this.sleep = sleep;
        this.countDownLatch = new CountDownLatch(countDownLatch);
    }

    public void run() {

        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            this.s.release(1);
            this.s1.release(1);
            System.out.println("Fir1 am dat");
            System.out.println(this.getName() + " - STATE 3");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }
        }
    }
