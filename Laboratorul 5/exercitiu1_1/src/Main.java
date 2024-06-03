import java.util.concurrent.Semaphore;

class Pcmd{

    Semaphore s = new Semaphore(0);

    int cmd; // poate avea valori -1, 0, 1

    public void waitForToken() {

        try {

            s.acquire();

        } catch (InterruptedException e) { }

    }

    public void setCmd(int cmd) {

        this.cmd = cmd;

        s.release(); // !!!

    }

}



class Ppoz{

    int x;

}



class Pmov {

    int x;

}



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