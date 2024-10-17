package ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cantec {
    public Cantec() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/ex2/cantec_in.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Vers> versuri = new ArrayList<>();
        Random random = new Random();
        String litere_sfarsit = "ii";

        while (scanner.hasNextLine()) {
            String linie = scanner.nextLine();
            versuri.add(new Vers(linie));
        }
        scanner.close();

        PrintWriter output = new PrintWriter(new FileWriter("src/ex2/cantec_out.txt"));
        for (Vers vers : versuri) {
            int nrCuvinte = vers.nr_cuvinte();
            int nrVocale = vers.nr_vocale();
            boolean terminareSir = vers.terminare_sir(litere_sfarsit);

            double numarAleator = random.nextDouble();
            String linieDeScris = vers.get_vers();
            if (numarAleator < 0.1) {
                linieDeScris = vers.transf_majuscule(); // Transformăm în majuscule
            }


            String linieOutput = linieDeScris + " | Cuvinte: " + nrCuvinte + " | Vocale: " + nrVocale;
            if (terminareSir) {
                linieOutput += " *"; // Adăugăm * dacă se termină cu șirul specificat
            }


            output.println(linieOutput);
        }
        output.close();
    }
}
