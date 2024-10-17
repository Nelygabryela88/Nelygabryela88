package ex4;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    // Metodă care calculează vârsta pe baza CNP-ului
    public int getVarsta() {
        // Extragem anul, luna și ziua din CNP
        String an = cnp.substring(1, 3);
        String luna = cnp.substring(3, 5);
        String zi = cnp.substring(5, 7);

        int anNastere;
        char primaCifra = cnp.charAt(0);

        // Determinăm secolul nașterii pe baza primei cifre din CNP
        if (primaCifra == '1' || primaCifra == '2') {
            anNastere = Integer.parseInt("19" + an); // Secolul XX
        } else if (primaCifra == '5' || primaCifra == '6') {
            anNastere = Integer.parseInt("20" + an); // Secolul XXI
        } else {
            throw new IllegalArgumentException("CNP invalid pentru calculul vârstei.");
        }

        // Creăm data de naștere
        LocalDate dataNasterii = LocalDate.of(anNastere, Integer.parseInt(luna), Integer.parseInt(zi));
        LocalDate dataCurenta = LocalDate.now();

        // Calculăm vârsta pe baza diferenței între data curentă și data nașterii
        return Period.between(dataNasterii, dataCurenta).getYears();
    }

    // Metodă care verifică validitatea CNP-ului
    public static boolean cnpValid(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }

        // Verificăm dacă toate caracterele sunt cifre
        if (!cnp.matches("\\d+")) {
            return false;
        }

        // Verificăm prima cifră
        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }

        // Algoritmul pentru calculul cifrei de control
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += (cnp.charAt(i) - '0') * coeficienti[i];
        }
        int cifraDeControl = suma % 11;
        if (cifraDeControl == 10) {
            cifraDeControl = 1;
        }

        return cifraDeControl == (cnp.charAt(12) - '0');
    }

    @Override
    public String toString() {
        return nume + ", CNP: " + cnp + ", Vârsta: " + getVarsta();
    }
}

