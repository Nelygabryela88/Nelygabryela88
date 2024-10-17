package ex1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Judete {
  public static void main(String[] args) throws FileNotFoundException {
        File file=new File("src/judete.txt");
        Scanner scanner=new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(",");
        }
      String[] judete = sb.toString().split(",");
        Arrays.sort(judete);

      scanner.close();
      Scanner inputScanner = new Scanner(System.in);
      System.out.print("Judetul este:");
      String judet_cautat = inputScanner.nextLine();
      int i = Arrays.binarySearch(judete, judet_cautat);
      if (i >= 0) {
          System.out.println("Județul  se află pe poziția " + (i + 1) );
      } else {
          System.out.println("Județul nu a fost găsit în listă.");
      }

    }
}
