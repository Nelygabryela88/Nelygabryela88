package lab4;

public class SistemDeCalcul extends Echipament {
    private String tipMon;
    private double vitProc;
    private int cHdd;
    private SistemOperare sistemOperare;

    public SistemDeCalcul(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare,
                          String tipMon, double vitProc, int cHdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.cHdd = cHdd;
        this.sistemOperare = sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return super.toString() + " SistemDeCalcul{" +
                "tipMon='" + tipMon + '\'' +
                ", vitProc=" + vitProc +
                ", cHdd=" + cHdd +
                ", sistemOperare=" + sistemOperare +
                '}';
    }
}

