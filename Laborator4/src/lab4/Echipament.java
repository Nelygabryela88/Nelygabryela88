package lab4;
import java.io.Serializable;
public class Echipament implements Serializable {
    protected String denumire;
    protected int nr_inv;
    protected double pret;
    protected String zona_mag;
    protected StareEchipament stare;

    public Echipament(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare) {
        this.denumire = denumire;
        this.nr_inv = nrInv;
        this.pret = pret;
        this.zona_mag = zonaMag;
        this.stare = stare;
    }

    public void setStare(StareEchipament stare) {
        this.stare = stare;
    }

    public StareEchipament getStare() {
        return stare;
    }

    @Override
    public String toString() {
        return "Echipament{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare=" + stare +
                '}';
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public int getNrInv() {
        return getNr_inv();
    }

    public void setNrInv(int nrInv) {
        this.nr_inv = nrInv;
    }
}
