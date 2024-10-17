package ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citim numărul de persoane
        System.out.println("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // curățăm bufferul

        // Creăm un vector de persoane
        Persoana[] persoane = new Persoana[n];

        // Citim datele pentru fiecare persoană
        for (int i = 0; i < n; i++) {
            System.out.println("Introduceți numele persoanei " + (i + 1) + ": ");
            String nume = scanner.nextLine();

            String cnp;
            // Validăm CNP-ul până când este corect
            while (true) {
                System.out.println("Introduceți CNP-ul persoanei " + (i + 1) + ": ");
                cnp = scanner.nextLine();
                if (Persoana.cnpValid(cnp)) {
                    break;  // ieșim din buclă dacă CNP-ul este valid
                } else {
                    System.out.println("CNP-ul introdus este invalid. Încercați din nou.");
                }
            }

            // Creăm un obiect de tip Persoana și îl adăugăm în vector
            persoane[i] = new Persoana(nume, cnp);
        }

        // Afișăm informațiile pentru fiecare persoană
        System.out.println("\nInformațiile introduse:");
        for (Persoana persoana : persoane) {
            System.out.println(persoana);
        }

        scanner.close();
    }
}
