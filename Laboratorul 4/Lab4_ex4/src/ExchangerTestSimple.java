
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerTestSimple {
    public static void main(String args[]){
        Exchanger<List<Integer>> exchanger =
                new Exchanger<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Fir f1=new Fir(1000,exchanger,"Duke",list);
        Fir f2=new Fir(5000,exchanger,"Wild Wings",list);
        f1.start();
        f2.start();
    }
}