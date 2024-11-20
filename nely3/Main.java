package nely3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
public class Main {


    public static void scriere(Set<Mobilier> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/out.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Mobilier> citire() {
        try {
            File file=new File("src/main/resources/in.json");
            ObjectMapper mapper=new ObjectMapper();
            List<Mobilier> mobila = mapper
                    .readValue(file, new TypeReference<List<Mobilier>>(){});
            return mobila;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static Dulap celMaiScundDulap(Set<Mobilier> mobilier) {
        return mobilier.stream()
                .filter(m -> m instanceof Dulap)
                .map(m -> (Dulap) m)
                .min(Comparator.comparing(Dulap::getInaltime))
                .orElse(null);
    }

    public static void afiseazaDulapuriSpeciale(Set<Mobilier> mobilier) {
        List<Dulap> dulapuri = mobilier.stream()
                .filter(m -> m instanceof Dulap)
                .map(m -> (Dulap) m)
                .filter(d -> d.getNrRafturi() == 5 && d.getInaltime() > 120)
                .collect(Collectors.toList());

        if (dulapuri.isEmpty()) {
            System.out.println("Nu există dulapuri cu 5 rafturi și înălțime peste 120 cm.");
        } else {
            dulapuri.forEach(System.out::println);
        }
    }

    public static void main(String[] args) throws IOException {
//        List<Mobilier> mobilier = new ArrayList<>();
        Set<Mobilier> mobilierSet = new HashSet<>();
        mobilierSet.add(new Dulap("IKEA", 500, 5, 150));
        mobilierSet.add(new Dulap("Amarildo", 300, 4, 100));
        mobilierSet.add(new Dulap("MobExpert", 700, 5, 130));
        mobilierSet.add(new Canapea("TotalMobila", 1200, 3, TipCanapea.Extensibila));
        mobilierSet.add(new Canapea("Dedeman", 800, 2, TipCanapea.Clasica));

        // Scriem obiectele în fișierul out.json
        scriere(mobilierSet);
//        mobilier.add(new Dulap("IKEA", 500, 5, 150));
//        mobilier.add(new Dulap("Amarildo", 300, 4, 100));
//        mobilier.add(new Dulap("MobExpert", 700, 5, 130));
//        mobilier.add(new Canapea("TotalMobila", 1200, 3, TipCanapea.Extensibila));
//        mobilier.add(new Canapea("Dedeman", 800, 2, TipCanapea.Clasica));
//
//        scriere(mobilier);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișează toate mobila");
            System.out.println("2. Afișează cel mai scund dulap");
            System.out.println("3. Afișează dulapuri cu 5 rafturi și înălțime > 120 cm");
            System.out.println("4. Calculează lungimea canapelei");
            System.out.println("5. Salvează și ieși");
            System.out.println("0. Ieșire");
            System.out.print("Alege o opțiune: ");

            int optiune = scanner.nextInt();
            switch (optiune) {
                case 0:System.exit(0);
                    break;
                case 1:
                    mobilierSet.forEach(System.out::println);
                    break;
                case 2:
                    Dulap celMaiScund = celMaiScundDulap(mobilierSet);
                    if (celMaiScund != null) {
                        System.out.println("Cel mai scund dulap: " + celMaiScund);
                    } else {
                        System.out.println("Nu există dulapuri.");
                    }
                    break;
                case 3:
                    afiseazaDulapuriSpeciale(mobilierSet);
                    break;
                case 4:
                    mobilierSet.stream()
                            .filter(m -> m instanceof Canapea)
                            .forEach(m -> {
                                Canapea canapea = (Canapea) m;
                                System.out.println("Canapea: " + canapea + ", Lungime: " + canapea.lungime_canapea() + " cm");
                            });
                    break;
                case 5:
                    scriere(mobilierSet);
                    System.out.println("Datele au fost salvate.");
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        }
    }
}
