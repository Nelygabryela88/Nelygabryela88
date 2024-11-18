package Incercare2;

import java.time.LocalDate;

public class Student extends Persoane {
    private int an;
    private String specializare;
    private String facultate;

    public Student() {

    }

    // Constructor
    public Student(String nume, tip tipul, LocalDate data_nasterii, String specializare, String facultate, int an) {
        super(nume, tipul, data_nasterii);
        this.specializare = specializare;
        this.facultate = facultate;
        this.an = an;
    }

    // Getteri
    public int getAn() {
        return an;
    }

    public String getSpecializare() {
        return specializare;
    }

    public String getFacultate() {
        return facultate;
    }

    // Setteri
    public void setAn(int an) {
        this.an = an;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    // Suprascrierea metodei toString()
    @Override
    public String toString() {
        return "Student{" +
                "nume='" + getNume() + '\'' +
                ", tipul=" + getTipul() +
                ", data_nasterii=" + getData_nasterii() +
//                ", varsta=" + getVarsta() +
                ", specializare='" + specializare + '\'' +
                ", facultate='" + facultate + '\'' +
                ", an=" + an +
                '}';
    }
}
