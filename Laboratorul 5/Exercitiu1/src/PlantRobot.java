import java.util.concurrent.Semaphore;
public class PlantRobot extends Thread {

    Pcmd pcmd;

    Ppoz ppoz;

    Pmov pmov;

    PpozPlant ppozplant;

    public PlantRobot(Pcmd pcmd, PpozPlant ppozplant) {

        this.pcmd = pcmd;

        this.ppozplant = ppozplant;

        ppoz = new Ppoz();

        pmov = new Pmov();

    }

    public void run() {

        while (true) {

// jeton in ppoz;

            pcmd.waitForToken(); // grd for t1

            pmov.x = ppoz.x + pcmd.cmd;

            System.out.println("s-a executat t1, se misca spre " + pmov.x);

            try {

                Thread.sleep(3000);

            } catch (InterruptedException e) {
            }

            ppoz.x = pmov.x;

            ppozplant.setPoz(pmov.x);

            System.out.println("s-a executat t2,am ajuns in " + ppoz.x);

        }

    }
}

