import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock l1=new ReentrantLock();
        Lock l2= new ReentrantLock();
        Fir f1,f2;
        f1=new Fir(l1,l2,4,4,2,6,4);
        f2= new Fir(l2,l1,5,5,3,7,5);
        f1.start();
        f2.start();
    }
}