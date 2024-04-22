import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.Semaphore;


public class Fir2 extends Thread {
    CyclicBarrier bariera;
    Semaphore s1;
    Semaphore s;
    int activity_max, activity_min, permise, sleep;

    Fir2(Semaphore s, Semaphore s1, int min_activity, int max_activity, int permise, int sleep) {
        this.activity_max = max_activity;
        this.activity_min = min_activity;
        this.bariera = bariera;
        this.s1 = s1;
        this.s = s;
        this.permise = permise;
        this.sleep = sleep;
    }

    public void run() {
        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                this.s.acquire(1); // s1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                this.s1.acquire(1); // s2
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 2");
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.s.release(1);
                this.s1.release(1);
            }
        }
    }
