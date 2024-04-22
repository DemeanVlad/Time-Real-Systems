import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
public class Main {

    public static void main(String args[]) {

        Semaphore s = new Semaphore(2);

        Fir f1, f2, f3;

        f1 = new Fir(s, 4,3, 1,1);

        f2 = new Fir( s, 3, 6, 1,2);

        f3 = new Fir( s, 5, 7, 1,3);
        f1.start();
        f2.start();
        f3.start();

    }

}