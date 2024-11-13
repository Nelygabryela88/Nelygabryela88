package ex1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src/ex1/in.txt");
        Scanner scanner = new Scanner(file);
        List<Parabola> parabole = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String linie = scanner.nextLine();
            String[] coeficienti = linie.trim().split("\\s+");
            int a = Integer.parseInt(coeficienti[0]);
            int b = Integer.parseInt(coeficienti[1]);
            int c = Integer.parseInt(coeficienti[2]);
            parabole.add(new Parabola(a, b, c));//ad ob de tip parabola
        }
        scanner.close();


        for (Parabola p : parabole) {
            double[] varf = p.get_varf();
            System.out.println(p + " are cordonatele varfului: (" + varf[0] + ", " + varf[1] + ")");
        }

       // calc coord mij seg și L seg
        if (parabole.size() >= 2) {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);
            double[] mijloc = Parabola.coord_mijloc_static(p1, p2);

            System.out.println("Coordonate mijloc: (" + mijloc[0] + ", " + mijloc[1] + ")");

            double lungime = Parabola.lungime_segment_static(p1, p2);
            System.out.println("Lungimea segmentului : " + lungime);
        } else {
            System.out.println("Nu există suficiente parabole pentru a calc. mijlocul segmentului și lungimea ");
        }
    }
}
