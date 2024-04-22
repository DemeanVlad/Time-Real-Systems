import java.util.concurrent.locks.Lock;
import java.util.concurrent.Semaphore;
class Fir extends Thread {
    int nume, intarziere, k, permise;
    Semaphore s = new Semaphore(2);
    int activity_min2 = 1;
    int activity_max2 = 5;

    Fir(int n, Semaphore sa, int intarziere, int k, int permise) {
        this.nume = n;
        this.s = sa;
        this.intarziere = intarziere;
        this.k = k;
        this.permise = permise;

    }

    public void run() {
        while (true) {
            try {
                System.out.println(this.getName() + " - STATE 1");
                Thread.sleep(this.intarziere * 500);

                System.out.println(this.getName() + " - STATE 2");

                if (this.nume == 1) {
                    s.acquire(2); //
                } else if (this.nume == 2) {
                    s.acquire(1); //
                }


                System.out.println("Fir " + nume + " a luat un jeton din semafor");
                System.out.println(this.getName() + " - STATE 3");


                int k1 = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
                for (int i = 0; i < k1 * 100000; i++) {
                    i++;
                    i--;
                }

                if (this.nume == 1) {
                    s.release(1);
                } else if (this.nume == 2) {
                    s.release(2);
                }

                System.out.println("Fir " + nume + " a eliberat un jeton din semafor");
                System.out.println(this.getName() + " - STATE 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}