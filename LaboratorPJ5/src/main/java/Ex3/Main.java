package Ex3;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Main {
    public static void scriere(List<PerecheNumere> lista) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/perechi_numere.json"), lista);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static List<PerecheNumere> citire() {
        ObjectMapper mapper = new ObjectMapper();
        List<PerecheNumere> lista = new ArrayList<>();
        try {
            lista = mapper.readValue(new File("src/main/perechi_numere.json"), new TypeReference<List<PerecheNumere>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public static void main(String[] args) {

        PerecheNumere p1 = new PerecheNumere(13, 21);
        PerecheNumere p2 = new PerecheNumere(5, 8);
        PerecheNumere p3 = new PerecheNumere(12, 16);

        List<PerecheNumere> listaPerechi = new ArrayList<>(Arrays.asList(p1, p2, p3));

        System.out.println(listaPerechi);

        scriere(listaPerechi);

        List<PerecheNumere> perechiCitite = citire();

        System.out.println("Perechi citite din fișier:");
        for (PerecheNumere p : perechiCitite) {
            System.out.println(p);
        }
        for (PerecheNumere p : perechiCitite) {
            System.out.println("Pereche: " + p);
            System.out.println("Consecutive Fibonacci: " + p.suntConsecutiveFibonacci());
            System.out.println("Cel Mai Mic Multiplu Comun: " + p.celMaiMicMultipluComun());
            System.out.println("Suma Cifrelor Egala: " + p.sumaCifrelorEgala());
            System.out.println("Aceeași Număr Cifre Pare: " + p.aceeasiNumarCifrePare());
            System.out.println();
        }
    }


    }




