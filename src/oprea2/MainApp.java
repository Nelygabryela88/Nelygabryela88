package oprea2;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("n = ");
        int n = Scanner.nextInt();
        int c;
        int s = 0;

        if (n < 0) {
            System.out.println("Introdu un numar intreg pozitiv.");
            Scanner.close();
            return;
        }

        while (n > 0) {
            c = n % 10;
            if (c % 2 == 0) {
                s += c;
            }
            n = n / 10;
        }

        System.out.println("s = " + s);
        Scanner.close();
    }
}
