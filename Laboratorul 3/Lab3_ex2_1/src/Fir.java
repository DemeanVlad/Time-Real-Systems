import java.util.concurrent.locks.Lock;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
class Fir extends Thread {
    int nume, intarziere, k, permise;
    Semaphore s;
    int activity_min2 = 1;
    int activity_max2 = 5;
    int stare;
    private static final Object lock = new Object();
    Fir(int n, int st,Semaphore sa, int intarziere, int k, int permise) {
        this.nume = n;
        this.stare = st;
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

                synchronized (lock) {
                    if (this.nume == 1 && stare == 1) {
                        s.acquire(); // Firul 1 așteaptă să obțină un jeton
                        stare = 2; // Schimbă starea pentru a indica că firul 1 a obținut un jeton
                    } else if (this.nume == 2 && stare == 2) {
                        s.acquire(); // Firul 2 așteaptă să obțină un jeton
                        stare = 1; // Schimbă starea pentru a indica că firul 2 a obținut un jeton
                    }
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
