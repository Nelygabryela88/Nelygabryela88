package nely1;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {

    public static void scriere(List<Carte> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/carti.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Carte> citire() {
        try {
            File file = new File("src/main/resources/carti.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<Carte>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void cautaregen(List<Carte> lista, String gen) {
        lista.stream()
                .filter(carte -> carte.getGen().equalsIgnoreCase(gen))
                .forEach(System.out::println);
    }
    public static void afisare_autori_tineri(List<Carte> lista) {
        lista.stream()
                .filter(carte -> carte.getGen().equalsIgnoreCase("FICTIUNE"))
                .flatMap(carte -> carte.getAutori().stream())
                .filter(autor -> autor.getVarsta() < 40)
                .map(Autor::getNume)
                .distinct()
                .forEach(System.out::println);
    }
    public static void autor_multe_carti(List<Carte> lista) {
        Map<Autor, Long> autorCount = lista.stream()
                .flatMap(carte -> carte.getAutori().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        autorCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println("Autor cu cele mai multe publicații: " + entry.getKey().getNume()));
    }
    public static void ordonare_alfabetic(List<Carte> lista) {
        lista.stream()
                .sorted(Comparator.comparing(Carte::getTitlu))
                .forEach(System.out::println);
    }
    public static void carti_multi_autori(List<Carte> lista) {
        lista.stream()
                .filter(carte -> carte.getAutori().size() > 1)
                .forEach(System.out::println);
    }




    public static void main(String[] args) {

        List<Carte> lista = new ArrayList<>();

        Autor autor1 = new Autor("Ion Creangă", "România", 37);
        Autor autor2 = new Autor("Mihai Eminescu", "România", 39);
        Autor autor3 = new Autor("Jules Verne", "Franța", 58);
        Autor autor4 = new Autor("Mark Twain", "SUA", 45);
        Autor autor5 = new Autor("George Coșbuc", "România", 38);

        lista.add(new Carte("Amintiri din copilărie", "FICTIUNE", 1881, List.of(autor1)));
        lista.add(new Carte("Poezii", "FICTIUNE", 1883, List.of(autor2)));
        lista.add(new Carte("Călătorie spre centrul Pământului", "STIINTA", 1864, List.of(autor3)));
        lista.add(new Carte("Aventurile lui Tom Sawyer", "FICTIUNE", 1876, List.of(autor4)));
        lista.add(new Carte("Balade și Idile", "FICTIUNE", 1893, List.of(autor5, autor1)));
        scriere(lista);
        List<Carte> cartiIncarcate = citire();
        if (cartiIncarcate != null) {
            cartiIncarcate.forEach(System.out::println);
        }
        System.out.println("\nCărți de ficțiune:");
        cautaregen(lista, "FICTIUNE");

        System.out.println("\nAutori tineri (sub 40 de ani):");
        afisare_autori_tineri(lista);

        System.out.println("\nAutor cu cele mai multe cărți:");
        autor_multe_carti(lista);

        System.out.println("\nCărți în ordine alfabetică după titlu:");
        ordonare_alfabetic(lista);

        System.out.println("\nCărți cu mai mulți autori:");
        carti_multi_autori(lista);
    }
}