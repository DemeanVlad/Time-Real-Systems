import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Fir2 extends Thread {
        CountDownLatch countDownLatch;
        Semaphore  s1;
        Semaphore s;
        int activity_max, activity_min , sleep;
        public Fir2( Semaphore s1, int min_activity, int max_activity, int sleep, int countDownLatch) {
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
                    this.s1.acquire(1);
                    System.out.println("Fir2&3 am luat");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(sleep * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                System.out.println(this.getName() + " - STATE 3");
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

