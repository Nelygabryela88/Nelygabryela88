package ex2;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Magazin {

    public static List<Produs> produse = new ArrayList<>();

    public static void main(String[] args) {
        citireProduseDinFisier("src/ex2/produse.txt");

        Scanner scanner = new Scanner(System.in);
        boolean ruleaza = true;

        while (ruleaza) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișează toate produsele");
            System.out.println("2. Afișează produsele expirate");
            System.out.println("3. Vinde un produs");
            System.out.println("4. Afișează produse cu preț minim");
            System.out.println("5. Salvează produsele cu cantitate mai mică decât o valoare dată");
            System.out.println("6. Afișează încasările totale");
            System.out.println("0. Ieșire");

            int optiune = scanner.nextInt();
            scanner.nextLine();  // Consuma newline-ul

            switch (optiune) {
                case 1:
                    afisareToateProdusele();
                    break;
                case 2:
                    afisareProduseExpirate();
                    break;
                case 3:
                    vindeProdus(scanner);
                    break;
                case 4:
                    afisareProdusePretMinim();
                    break;
                case 5:
                    salvareProduseCuCantitateRedusa(scanner);
                    break;
                case 6:
                    System.out.println("Încasări totale: " + Produs.get_incasari() + " lei");
                    break;
                case 0:
                    ruleaza = false;
                    break;
                default:
                    System.out.println("Opțiune invalidă. Te rog alege din nou.");
            }
        }

        scanner.close();
    }

    public static void citireProduseDinFisier(String numeFisier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] campuri = linie.split(",");
                String denumire = campuri[0].trim();
                float pret = Float.parseFloat(campuri[1].trim());
                int cantitate = Integer.parseInt(campuri[2].trim());
                LocalDate data_expirare = LocalDate.parse(campuri[3].trim());

                Produs produs = new Produs(denumire, pret, cantitate, data_expirare);
                produse.add(produs);
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }
    }

    public static void afisareToateProdusele() {
        if (produse.isEmpty()) {
            System.out.println("Nu există produse în stoc.");
        } else {
            System.out.println("Produsele disponibile:");
            for (Produs produs : produse) {
                System.out.println(produs);
            }
        }
    }

    public static void afisareProduseExpirate() {
        boolean existaExpirate = false;
        for (Produs produs : produse) {
            if (produs.este_expirat()) {
                System.out.println(produs);
                existaExpirate = true;
            }
        }
        if (!existaExpirate) {
            System.out.println("Nu există produse expirate.");
        }
    }

    public static void vindeProdus(Scanner scanner) {
        System.out.println("Introdu numele produsului de vândut:");
        String numeProdus = scanner.nextLine();
        System.out.println("Introdu cantitatea de vândut:");
        int cantitateDeVandut = scanner.nextInt();

        boolean gasit = false;
        Iterator<Produs> iterator = produse.iterator();
        while (iterator.hasNext()) {
            Produs produs = iterator.next();
            if (produs.get_denumire().equalsIgnoreCase(numeProdus)) {
                gasit = true;
                if (produs.get_cantitate() >= cantitateDeVandut) {
                    produs.set_cantitate(produs.get_cantitate() - cantitateDeVandut);
                    Produs.adaugare_incasari((float) (produs.get_pret() * cantitateDeVandut));

                    System.out.println("Produs vândut cu succes.");
                    if (produs.get_cantitate() == 0) {
                        iterator.remove();
                        System.out.println("Produsul " + numeProdus + " a fost epuizat și eliminat din stoc.");
                    }
                } else {
                    System.out.println("Stoc insuficient pentru " + numeProdus + ".");
                }
                break;
            }
        }

        if (!gasit) {
            System.out.println("Produsul " + numeProdus + " nu a fost găsit.");
        }
    }

    public static void afisareProdusePretMinim() {
        if (produse.isEmpty()) {
            System.out.println("Nu există produse în stoc.");
            return;
        }

        double pretMinim = produse.stream().mapToDouble(Produs::get_pret).min().getAsDouble();
        System.out.println("Produse cu preț minim (" + pretMinim + " lei):");

        for (Produs produs : produse) {
            if (produs.get_pret() == pretMinim) {
                System.out.println(produs);
            }
        }
    }

    public static void salvareProduseCuCantitateRedusa(Scanner scanner) {
        System.out.println("Introdu valoarea maximă a cantității pentru a salva produsele:");
        int cantitateMaxima = scanner.nextInt();

        try (PrintWriter writer = new PrintWriter(new FileWriter("produse_cantitate_redusa.csv"))) {
            for (Produs produs : produse) {
                if (produs.get_cantitate() < cantitateMaxima) {
                    writer.println(produs);
                }
            }
            System.out.println("Produsele au fost salvate în fișierul produse_cantitate_redusa.csv.");
        } catch (IOException e) {
            System.out.println("Eroare la salvarea fișierului: " + e.getMessage());
        }
    }
}
