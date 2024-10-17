package ex4;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        int nr = 0;
        System.out.print("Divizorii numărului " + n + " sunt: ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                nr++;
                System.out.print(i + " ");
            }
        }
        if (nr == 2) {
            System.out.println("\nNumărul este prim");
        } else {
            System.out.println("\nNumărul  nu este prim");
        }
        scanner.close();
    }
}
