import java.util.concurrent.Semaphore;
class PpozPlant{

    Semaphore s = new Semaphore(0);

    int x;

    public void waitForToken() {

        try {

            s.acquire();

        } catch (InterruptedException e) { }

    }

    public void setPoz(int poz) {

        this.x = poz;

        s.release(); // !!!

    }



} 