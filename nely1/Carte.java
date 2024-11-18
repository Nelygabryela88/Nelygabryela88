package nely1;
import java.util.*;
import java.io.*;
import java.util.List;

class Carte {
    private String titlu;
    private String gen; // Poate fi extinsă cu un enum
    private int anulPublicarii;
    private List<Autor> autori;

    // Constructor implicit
    public Carte() {}

    // Constructor parametrizat
    public Carte(String titlu, String gen, int anulPublicarii, List<Autor> autori) {
        this.titlu = titlu;
        this.gen = gen;
        this.anulPublicarii = anulPublicarii;
        this.autori = autori;
    }

    // Getter-e și Setter-e
    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getAnulPublicarii() {
        return anulPublicarii;
    }

    public void setAnulPublicarii(int anulPublicarii) {
        this.anulPublicarii = anulPublicarii;
    }

    public List<Autor> getAutori() {
        return autori;
    }

    public void setAutori(List<Autor> autori) {
        this.autori = autori;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", gen='" + gen + '\'' +
                ", anulPublicarii=" + anulPublicarii +
                ", autori=" + autori +
                '}';
    }
}