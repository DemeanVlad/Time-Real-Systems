import java.util.concurrent.locks.Lock;
import java.util.concurrent.Semaphore;

class Fir extends Thread {

    int  n;
    int activity_max,activity_min, permise,sleep;

    Semaphore s;

    Fir(Semaphore s, int min_activity,int max_activity, int permise,int sleep) {
        this.activity_max = max_activity;

        this.activity_min = min_activity;

        this.s = s;

        this.permise = permise;

        this.sleep = sleep;

    }

    public void run() {

        while (true) {
            try {
                System.out.println(this.getName() + " - STATE 1");
                this.s.acquire(1);

                System.out.println(this.getName() + " - STATE 2");

                int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                this.s.release(1);

                System.out.println(this.getName()+" - STATE 3");
                this.sleep(sleep*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 4");
        }
    }

}
