public class Pplantrobot extends Thread{

    Pcmd Pcmd;

    Ptask Ppoz;

    Pfeedback Ppmov;

    Pplantrobot Ppozplant;

    public Pplantrobot(Pcmd pcmd,Ptask ppoz,Pfeedback pmov,Pplantrobot ppozplant) {

        this.pcmd = pcmd;

        this.ppozplant = ppozplant;

        this.ppoz = ppoz;

        this.pmov = pmov;

        ppoz = new Ppoz();

        pmov = new Pmov();

    }