package ex5;

import java.util.Random;

public class MainApp {
    public static int cmmdc(int a, int b) {
        while (b != 0) {
            int aux = b;
            b = a % b;
            a = aux;
        }
        return a;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int nr1 = random.nextInt(30) + 1;
        int nr2 = random.nextInt(30) + 1;
        System.out.println("Numărul 1 generat aleatoriu: " + nr1);
        System.out.println("Numărul 2 generat aleatoriu: " + nr2);
        int cmmdcResult = cmmdc(nr1, nr2);
        System.out.println("CMMDC este: " + cmmdcResult);
    }
}
