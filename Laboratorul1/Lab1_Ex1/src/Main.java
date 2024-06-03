//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double real1 = 2, imaginary1 = 5;
        double real2 = 4, imaginary2 = -1;

        // Calculul sumei
        double sumReal = real1 + real2;
        double sumImaginary = imaginary1 + imaginary2;
        System.out.println("Suma: " + sumReal + " + " + sumImaginary + "i");

        // Calculul produsului
        double productReal = real1 * real2 - imaginary1 * imaginary2;
        double productImaginary = real1 * imaginary2 + imaginary1 * real2;
        System.out.println("Produsul: " + productReal + " + " + productImaginary + "i");
        //output:
        //Suma: 6.0 + 4.0i
        //Produsul: 13.0 + 18.0i
    }
}