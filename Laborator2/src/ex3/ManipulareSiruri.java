package ex3;

import java.util.Scanner;

public class ManipulareSiruri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți șirul principal: ");
        String sirPrincipal = scanner.nextLine();

        // Folosim StringBuilder pentru a facilita modificările
        StringBuilder sb = new StringBuilder(sirPrincipal);
        System.out.println("Introduceți șirul care va fi inserat: ");
        String sirDeInserat = scanner.nextLine();
        System.out.println("Introduceți poziția unde va fi inserat șirul: ");
        int pozitieInserare = scanner.nextInt();
        scanner.nextLine();  // Curățăm bufferul de newline
        // Verif poz
        if (pozitieInserare < 0 || pozitieInserare > sb.length()) {
            System.out.println("Poziția de inserare este invalidă.");
        } else {
            sb.insert(pozitieInserare, sirDeInserat);
            System.out.println("Șirul după inserare: " + sb.toString());
        }
        System.out.println("Introduceți poziția de unde va începe ștergerea: ");
        int pozitieStergere = scanner.nextInt();

        System.out.println("Introduceți numărul de caractere care vor fi șterse: ");
        int numarCaractereSterse = scanner.nextInt();

        // Verificăm dacă pozițiile de ștergere sunt valide
        if (pozitieStergere < 0 || pozitieStergere >= sb.length() || pozitieStergere + numarCaractereSterse > sb.length()) {
            System.out.println("Poziția sau numărul de caractere pentru ștergere este invalid.");
        } else {
            // Ștergem porțiunea specificată din șir
            sb.delete(pozitieStergere, pozitieStergere + numarCaractereSterse);
            System.out.println("Șirul după ștergere: " + sb.toString());
        }

        scanner.close();
    }
}

