package lab4;

public class Copiator extends Echipament {
    private int pTon;
    private FormatCopiere format;

    public Copiator(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare,
                    int pTon, FormatCopiere format) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.pTon = pTon;
        this.format = format;
    }

    public void setFormat(FormatCopiere format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + " Copiator{" +
                "pTon=" + pTon +
                ", format=" + format +
                '}';
    }



}
