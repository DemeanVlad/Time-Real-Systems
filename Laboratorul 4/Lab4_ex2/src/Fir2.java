import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.Semaphore.*;
import java.util.concurrent.CyclicBarrier;

class Fir2 extends Thread {
    CyclicBarrier bariera;
    Semaphore s,s1;
    int activity_max, activity_min, permise, sleep;

    public Fir2(Semaphore s, int min_activity, int max_activity, int permise, int sleep, int bariera, Semaphore s1) {
        this.activity_max = max_activity;
        this.activity_min = min_activity;
        this.s = s;
        this.s1 = s1;
        this.permise = permise;
        this.sleep = sleep;

    }


    public void run() {

        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                this.s.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.s.release(1);
                System.out.println(this.getName() + " - STATE 3");
                try {
                    bariera.await(); // asteapta aici
                } catch (InterruptedException | BrokenBarrierException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}