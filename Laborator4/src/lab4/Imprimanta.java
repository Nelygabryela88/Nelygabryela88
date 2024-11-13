package lab4;

public class Imprimanta extends Echipament {
    private int ppm;
    private int dpi;
    private int pCar;
    private TipImprimare modTiparire;

    public Imprimanta(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare,
                      int ppm, int dpi, int pCar, TipImprimare modTiparire) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.pCar = pCar;
        this.modTiparire = modTiparire;
    }

    public void setModTiparire(TipImprimare modTiparire) {
        this.modTiparire = modTiparire;
    }

    @Override
    public String toString() {
        return super.toString() + " Imprimanta{" +
                "ppm=" + ppm +
                ", dpi=" + dpi +
                ", pCar=" + pCar +
                ", modTiparire=" + modTiparire +
                '}';
    }
}


