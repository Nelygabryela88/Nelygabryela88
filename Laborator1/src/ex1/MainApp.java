package ex1;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("a=");
        int a = Scanner.nextInt();
        System.out.print("Ati introdus valoarea " + a);
        Scanner.close();
    }
}