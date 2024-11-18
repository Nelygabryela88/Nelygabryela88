package Incercare2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Metodă pentru citirea listei de persoane din fișier JSON
    public static List<Persoane> citire() {
        try {
            File file = new File("src/main/resources/persoana.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Persoane> persoane = mapper
                    .readValue(file, new TypeReference<List<Persoane>>() {
                    });
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void scriere(List<Persoane> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src/main/resources/persoana.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, lista);
            System.out.println("Datele au fost scrise în fișier.");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        List<Persoane> lista = new ArrayList<>();
        lista.add(new Student("Nely", tip.STUDENT, LocalDate.of(2003, 11, 8), "IS", "AC", 3));
        lista.add(new Profesor("Bican", tip.PROFESOR,LocalDate.of(1970,5,12),"Matematica",10));
        scriere(lista);
        lista.forEach(System.out::println);
        citire();
    }
}

