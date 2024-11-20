package nely3;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class Dulap extends Mobilier {
    private int nrRafturi;
    private float inaltime;

    public Dulap() {
    }

    public Dulap(String producator, float pret, int nrRafturi, float inaltime) {
        super(producator, pret);
        this.nrRafturi = nrRafturi;
        this.inaltime = inaltime;
    }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nrRafturi, inaltime);
    }


    public int getNrRafturi() {
        return nrRafturi;
    }

    public void setNrRafturi(int nrRafturi) {
        this.nrRafturi = nrRafturi;
    }

    public float getInaltime() {
        return inaltime;
    }

    public void setInaltime(float inaltime) {
        this.inaltime = inaltime;
    }

    @Override
    public String toString() {
        return "Dulap{" +
                "nrRafturi=" + nrRafturi +
                ", inaltime=" + inaltime +
                '}' + super.toString();
    }
}
