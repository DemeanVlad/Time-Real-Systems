import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//2 semafoare
        Semaphore s = new Semaphore(0);
        Semaphore s1 = new Semaphore(0);

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Fir1 f1 = new Fir1(s,s1,7,2,1,1);
        Fir2 f2 = new Fir2(s,5,3,1,1);
        Fir2 f3 = new Fir2(s1,5,4,1,1);

        f1.start();
        f2.start();
        f3.start();

        }
    }