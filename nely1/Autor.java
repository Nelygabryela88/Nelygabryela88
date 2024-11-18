package nely1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Clasa Autor
class Autor {
    private String nume;
    private String nationalitate;
    private int varsta;

    public Autor() {}


    public Autor(String nume, String nationalitate, int varsta) {
        this.nume = nume;
        this.nationalitate = nationalitate;
        this.varsta = varsta;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nume='" + nume + '\'' +
                ", nationalitate='" + nationalitate + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
