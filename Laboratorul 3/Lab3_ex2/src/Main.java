import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
public class Main {

    public static void main(String args[]) {

        Semaphore s = new Semaphore(1);

        Fir f1, f2;

        f1 = new Fir(1, s, 2, (int) Math.round(Math.random() * 3 + 2), 2);

        f2 = new Fir(2, s, 4, (int) Math.round(Math.random() * 3 + 3), 1);

        f1.start();

        f2.start();

    }

}