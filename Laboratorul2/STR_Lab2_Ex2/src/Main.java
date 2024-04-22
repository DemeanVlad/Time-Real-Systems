//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {

            Integer monitor1 = new Integer(1);
            Integer monitor2 = new Integer(2);

            new Thread1(monitor1, monitor2, 4, 5, 3, 6,5).start();
            new Thread1(monitor2, monitor1, 4, 5, 3, 6,5).start();

    }
}