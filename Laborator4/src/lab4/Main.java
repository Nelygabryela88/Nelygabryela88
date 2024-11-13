package lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static List<Echipament> echipamente = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File file = new File("src/lab4/echipamente.txt");
            citesteDinFisier(file);

            Scanner scanner = new Scanner(System.in);
            int opt;
            do {
                System.out.println("0. Iesire");
                System.out.println("1. Afisarea echipamentelor");
                System.out.println("2. Afisarea imprimantelor");
                System.out.println("3. Afisarea copiatoarelor");
                System.out.println("4. Afisarea sistemelor de calcul");
                System.out.println("5. Modificarea starii unui echipament");
                System.out.println("6. Setarea unui mod de scriere pentru o imprimanta");
                System.out.println("7. Setarea unui format de copiere pentru un copiator");
                System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
                System.out.println("9. Afisarea echipamentelor vandute");
                System.out.println("10. Salvare echipamente in fisier binar");
                System.out.println("11. Incarcare echipamente din fisier binar");

                System.out.print("Selecteaza o optiune: ");
                opt = scanner.nextInt();

                switch (opt) {
                    case 1:
                        afisareEchipamente();
                        break;
                    case 2:
                        afisareImprimante();
                        break;
                    case 3:
                        afisareCopiatoare();
                        break;
                    case 4:
                        afisareSistemeCalcul();
                        break;
                    case 5:
                        modificareStare(scanner);
                        break;
                    case 6:
                        setareModScriereImprimanta(scanner);
                        break;
                    case 7:
                        setareFormatCopiereCopiator(scanner);
                        break;
                    case 8:
                        instalareSistemOperare(scanner);
                        break;
                    case 9:
                        afisareEchipamenteVandute();
                        break;
                    case 10:
                        serializareColectie();
                        break;
                    case 11:
                        deserializareColectie();
                        break;
                    case 0:
                        exit(0);
                        break;
                    default:
                        System.out.println("Optiune gresita!");
                }
            } while (opt != 0);

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit: " + e.getMessage());
        }
    }

    private static void citesteDinFisier(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String linie = fileScanner.nextLine();
            String[] date = linie.split(";");
            String denumire = date[0];
            int nrInv = Integer.parseInt(date[1]);
            double pret = Double.parseDouble(date[2]);
            String zonaMag = date[3];
            StareEchipament stare = StareEchipament.valueOf(date[4].toUpperCase());

            if (date[5].equalsIgnoreCase("imprimanta")) {
                int ppm = Integer.parseInt(date[6]);
                int dpi = Integer.parseInt(date[7].split(" ")[0]);

                int paginiCartus = Integer.parseInt(date[8]);
                TipImprimare tipImprimare = TipImprimare.valueOf(date[9].toUpperCase());
                echipamente.add(new Imprimanta(denumire, nrInv, pret, zonaMag, stare, ppm, dpi, paginiCartus, tipImprimare));

            } else if (date[5].equalsIgnoreCase("copiator")) {
                int paginiToner = Integer.parseInt(date[6]);
                FormatCopiere format = FormatCopiere.valueOf(date[7].toUpperCase());
                echipamente.add(new Copiator(denumire, nrInv, pret, zonaMag, stare, paginiToner, format));

            } else if (date[5].equalsIgnoreCase("sistem de calcul")) {
                String tipMon = date[6];
                double vitezaProc = Double.parseDouble(date[7]);
                int capacitateHDD = Integer.parseInt(date[8]);
                SistemOperare sistemOperare = SistemOperare.valueOf(date[9].toUpperCase());
                echipamente.add(new SistemDeCalcul(denumire, nrInv, pret, zonaMag, stare, tipMon, vitezaProc, capacitateHDD, sistemOperare));
            }
        }
    }

    private static void afisareEchipamente() {
        for (Echipament e : echipamente) {
            System.out.println(e);
        }
    }

    private static void afisareImprimante() {
        for (Echipament e : echipamente) {
            if (e instanceof Imprimanta) {
                System.out.println(e);
            }
        }
    }

    private static void afisareCopiatoare() {
        for (Echipament e : echipamente) {
            if (e instanceof Copiator) {
                System.out.println(e);
            }
        }
    }

    private static void afisareSistemeCalcul() {
        for (Echipament e : echipamente) {
            if (e instanceof SistemDeCalcul) {
                System.out.println(e);
            }
        }
    }

    private static void modificareStare(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar: ");
        int nrInv = scanner.nextInt();
        for (Echipament e : echipamente) {
            if (e.getNrInv() == nrInv) {
                System.out.print("Introduceti noua stare (1-ACHIZITIONAT, 2-EXPUS, 3-VANDUT): ");
                int stare = scanner.nextInt();
                switch (stare) {
                    case 1:
                        e.setStare(StareEchipament.ACHIZITIONAT);
                        break;
                    case 2:
                        e.setStare(StareEchipament.EXPUS);
                        break;
                    case 3:
                        e.setStare(StareEchipament.VANDUT);
                        break;
                    default:
                        System.out.println("Optiune invalida!");
                }
                return;
            }
        }
        System.out.println("Echipamentul nu a fost gasit.");
    }

    private static void setareModScriereImprimanta(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar al imprimantei: ");
        int nrInv = scanner.nextInt();
        for (Echipament e : echipamente) {
            if (e instanceof Imprimanta && e.getNrInv() == nrInv) {
                System.out.print("Introduceti mod tiparire (1-ALB_NEGRU, 2-COLOR): ");
                int mod = scanner.nextInt();
                TipImprimare tipImprimare = (mod == 1) ? TipImprimare.ALB_NEGRU : TipImprimare.COLOR;
                ((Imprimanta) e).setModTiparire(tipImprimare);
                return;
            }
        }
        System.out.println("Imprimanta nu a fost gasita.");
    }

    private static void setareFormatCopiereCopiator(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar al copiatorului: ");
        int nrInv = scanner.nextInt();
        for (Echipament e : echipamente) {
            if (e instanceof Copiator && e.getNrInv() == nrInv) {
                System.out.print("Introduceti formatul (1-A4, 2-A3): ");
                int format = scanner.nextInt();
                FormatCopiere formatCopiere = (format == 1) ? FormatCopiere.A4 : FormatCopiere.A3;
                ((Copiator) e).setFormat(formatCopiere);
                return;
            }
        }
        System.out.println("Copiatorul nu a fost gasit.");
    }

    private static void instalareSistemOperare(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar al sistemului de calcul: ");
        int nrInv = scanner.nextInt();
        for (Echipament e : echipamente) {
            if (e instanceof SistemDeCalcul && e.getNrInv() == nrInv) {
                System.out.print("Introduceti sistemul de operare (1-WINDOWS, 2-LINUX): ");
                int sistem = scanner.nextInt();
                SistemOperare sistemOperare = (sistem == 1) ? SistemOperare.WINDOWS : SistemOperare.LINUX;
                ((SistemDeCalcul) e).setSistemOperare(sistemOperare);
                return;
            }
        }
        System.out.println("Sistemul de calcul nu a fost gasit.");
    }

    private static void afisareEchipamenteVandute() {
        for (Echipament e : echipamente) {
            if (e.getStare() == StareEchipament.VANDUT) {
                System.out.println(e);
            }
        }
    }

    private static void serializareColectie() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/lab4/echip.bin"))) {
            oos.writeObject(echipamente);
            System.out.println("Colectia a fost serializata cu succes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializareColectie() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/lab4/echip.bin"))) {
            echipamente = (List<Echipament>) ois.readObject();
            System.out.println("Colectia a fost deserializata cu succes.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
