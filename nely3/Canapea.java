package nely3;

import java.util.Objects;

public class Canapea extends Mobilier {
    private int nrLocuri;
    private TipCanapea tipCanapea;

    public Canapea() {
    }



    //subpunctul 6
    public int lungime_canapea()
    {
        return nrLocuri*40;
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nrLocuri, tipCanapea);
    }

    public Canapea(String producator, float pret, int nrLocuri, TipCanapea tipCanapea) {
        super(producator, pret);
        this.nrLocuri = nrLocuri;
        this.tipCanapea = tipCanapea;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public TipCanapea getTipCanapea() {
        return tipCanapea;
    }

    public void setTipCanapea(TipCanapea tipCanapea) {
        this.tipCanapea = tipCanapea;
    }

    @Override
    public String toString() {
        return "Canapea{" +
                "nrLocuri=" + nrLocuri +
                ", tipCanapea=" + tipCanapea +
                '}' + super.toString();
    }
}
