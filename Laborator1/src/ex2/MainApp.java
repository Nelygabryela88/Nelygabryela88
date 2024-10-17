package ex2;
import java.util.Scanner;
public class MainApp
{
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int L,l;
        System.out.print("l= ");
        l=Scanner.nextInt();
        System.out.print("L= ");
        L=Scanner.nextInt();
        System.out.println("Perimetrul= "+(l+L));
        System.out.println("Aria= "+(l*L));
    }
}
