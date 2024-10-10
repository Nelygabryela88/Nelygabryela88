package nely2;

import java.util.Scanner;

class MainApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("n = ");
        int n = scanner.nextInt();
        if (n % 2 == 0) {
            System.out.println("Numărul este par");
        } else {
            System.out.println("Numărul este impar");
        }
        scanner.close();
    }
}
