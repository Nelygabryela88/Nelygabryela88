package ex6;
//5. Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
//Programul va determina dacă numărul aparține șirului lui Fobonacci.
import java.util.Random;

public class MainApp {

    public static int esteFibonacci(int n) {
        if (patratPerfect(5 * n * n + 4) == 1 || patratPerfect(5 * n * n - 4) == 1) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int patratPerfect(int x) {
        int s = (int) Math.sqrt(x);
        if (s * s == x) {
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(21);
        System.out.println("Numărul generat aleatoriu: " + n);
        if (esteFibonacci(n) == 1) {
            System.out.println("Numărul  aparține șirului lui Fibonacci.");
        } else {
            System.out.println("Numărul nu aparține șirului lui Fibonacci.");
        }
    }
}
