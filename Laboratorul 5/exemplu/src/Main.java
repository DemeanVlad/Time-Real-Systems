import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți lungimea șirului de caractere: ");
        int n = scanner.nextInt();

        char[] caractere = new char[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            caractere[i] = (char) (random.nextInt(10) < 5 ? random.nextInt(26) + 'A' : random.nextInt(26) + 'a');
        }

        String sirInitial = new String(caractere);

        String sirNou = sirInitial.replaceAll("[0-9]", "*");

        System.out.println("Valoarea inițială a șirului: " + sirInitial);
        System.out.println("Valoarea după înlocuirea caracterelor numerice cu '*': " + sirNou);

        scanner.close();
    }
}