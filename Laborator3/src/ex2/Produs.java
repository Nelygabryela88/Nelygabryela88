package ex2;
import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class Produs { private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate data_expirare;
    private static double incasari = 0.0;

    public Produs(String denumire, float pret, int cantitate, LocalDate data_expirare) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirare = data_expirare;
    }
    public String get_denumire() {
        return denumire;
    }

    public double get_pret() {
        return pret;
    }

    public int get_cantitate() {
        return cantitate;
    }

    public void set_cantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate get_dataexpirare() {
        return data_expirare;
    }

    public static double get_incasari() {
        return incasari;
    }

    public static void adaugare_incasari(float suma) {
        incasari += suma;
    }
    public String toString() {
        return String.format("%s, %f lei, %d bucăți, Expiră la: %s", denumire, pret, cantitate, data_expirare);


    }
    public boolean este_expirat() {
        return LocalDate.now().isAfter(data_expirare);
    }

}
