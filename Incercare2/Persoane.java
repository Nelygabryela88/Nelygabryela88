package Incercare2;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.LocalDate;
import java.time.Period;
// json sa stie ce fel de tip am
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipul")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Student.class, name = "STUDENT"),
        @JsonSubTypes.Type(value = Profesor.class, name = "PROFESOR")
})

public class Persoane {
    private String nume;
    private tip tipul; // Enum pentru tipul persoanei
    private LocalDate data_nasterii;


    // Constructor\
    public Persoane()
    {}
    public Persoane(String nume, tip tipul, LocalDate data_nasterii) {
        this.nume = nume;
        this.tipul = tipul;
        this.data_nasterii = data_nasterii;
    }

    // Getteri și setteri
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public tip getTipul() {
        return tipul;
    }

    public void setTipul(tip tipul) {
        this.tipul = tipul;
    }

    public LocalDate getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(LocalDate data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

//    // Calcularea vârstei în funcție de data nașterii
//    public int getVarsta() {
//        return Period.between(data_nasterii, LocalDate.now()).getYears();
//    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", tipul=" + tipul +
                ", data_nasterii=" + data_nasterii +
//                ", varsta=" + getVarsta() +
                '}';
    }
}
