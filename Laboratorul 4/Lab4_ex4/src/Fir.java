import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

class Fir extends Thread{
    List<Integer> list=new ArrayList<Integer>();
    int sleepTime;
    Exchanger<List<Integer>> exchanger;
    String nume;

    Fir(int sT, Exchanger<List<Integer>> exchanger, String nume,List<Integer> list){
        this.sleepTime=sT;
        this.exchanger=exchanger;
        this.nume=nume;
        this.list = list;
    }

    public void afisLista(){
        System.out.println("Afiseaza lista:"+list);
    }

    public void run(){
        int noElem=(int)Math.round(Math.random()*3+1);
        for(int i=0;i<noElem;i++){//populeza lista cu un nr.
                                  //aleator de elemente
            int elem=(int)Math.round(Math.random()*100);
            list.add(elem);
        }
        this.afisLista();//afis lista inainte de schimb
        try {
            Thread.sleep(this.sleepTime);//firul asteapta x ms
            //se face schimbul de obiecte
            this.list=exchanger.exchange(this.list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.afisLista();//afis lista dupa schimb
    }
}