import java.util.concurrent.Semaphore;

public static void main(String[] args) throws InterruptedException {

    Pcmd pcmd = new Pcmd();

    PpozPlant ppozplant = new PpozPlant();

    PlantRobot p = new PlantRobot(pcmd, ppozplant);

    p.start();

    Thread.sleep(7000);

    pcmd.setCmd(1);

    ppozplant.waitForToken();

    System.out.println("am vazut ca plantul a ajuns in " + ppozplant.x);

    Thread.sleep(500);

    pcmd.setCmd(-1);


}

