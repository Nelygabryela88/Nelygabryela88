package ex3;
//Să se scrie un program care citește un set de numerele din fișierul de intrare in.txt, care
//conține câte un număr pe un rând, având valorile din figura 18. Programul va determină suma
//lor, media aritmetică, valoarea minimă, valoarea maximă, va afișa aceste valori pe ecran și le
//va scrie în fișierul de ieșire out.txt. Media aritmetică va fi afișată ca un număr real.

import java.io.*;
import java.util.Scanner;
import java.util.Vector;
public class MainApp
{ public static void main(String[] args) throws IOException {
    Vector<Integer> v = new Vector<>(9,2);
    //Scanner sc = new Scanner(System.in);
    Scanner scfisier = new Scanner(new File("src/ex3/in.txt"));
    while (scfisier.hasNextLine()) {
        int line=Integer.parseInt(scfisier.nextLine());
        //System.out.println(line);
        v.addElement(line);

    }
    int suma=0;
    float media=0;
    int max=0,min=v.getFirst();
    for (int i = 0; i < v.size(); i++) {
        suma+=v.get(i);

        if(v.get(i)>max)
        {
            max=v.get(i);
        }
        if(v.get(i)<min)
        {
            min=v.get(i);
        }
    }
    System.out.println(v.size());
    media= (float) suma /v.size();
    System.out.println("Suma= "+suma);
    System.out.println("Media= "+media);
    System.out.println("Min= "+min);
    System.out.println("Max= "+max);
    Writer wr = new FileWriter("src/ex3/out.txt");
    wr.write("\nSuma= "+suma);
    wr.write("\nMedia= "+media);
    wr.write("\nMin= "+min);
    wr.write("\nMax= "+max);
    wr.close();


}
}
