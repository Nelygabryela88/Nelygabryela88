package Incercare2;

import java.time.LocalDate;

public class Profesor extends Persoane {
    private String materie_predata;
    private int vechime;
public Profesor()
{

}

    // Constructor
    public Profesor(String nume, tip tipul, LocalDate data_nasterii, String materie_predata, int vechime) {
        super(nume, tipul, data_nasterii);
        this.materie_predata = materie_predata;
        this.vechime = vechime;
    }

    // Getteri
    public String getMaterie_predata() {
        return materie_predata;
    }

    public void setMaterie_predata(String materie_predata) {
        this.materie_predata = materie_predata;
    }

    public int getVechime() {
        return vechime;
    }

    public void setVechime(int vechime) {
        this.vechime = vechime;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nume='" + getNume() + '\'' +
                ", tipul=" + getTipul() +
                ", data_nasterii=" + getData_nasterii() +
//                ", varsta=" + getVarsta() +
                ", materie_predata='" + materie_predata + '\'' +
                ", vechime=" + vechime +
                '}';
    }
}
