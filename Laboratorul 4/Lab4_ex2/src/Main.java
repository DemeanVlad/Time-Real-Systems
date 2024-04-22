import java.util.concurrent.*;

public class Main {
    public static void main(String args[]) {
        Semaphore s = new Semaphore(2);
        Semaphore s1 = new Semaphore(1);

        CyclicBarrier bariera = new CyclicBarrier(3);


        Fir f1 = new Fir(s,2,4,1,4,3);

        Fir2 f2 = new Fir2(s,1,1,1,1,1,s1);

        Fir f3 = new Fir(s,2, 4, 1, 1, 3);

        f1.start();
        f2.start();
        f3.start();
    }
}