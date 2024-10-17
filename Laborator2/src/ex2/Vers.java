
///2. Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
/// program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
/// plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
/// de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
/// pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
/// fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
/// Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
/// reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
/// metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
/// Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
/// intrare.

package ex2;

public class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }
    public int nr_cuvinte() {
        if (vers == null || vers.isEmpty()) {
            return 0;
        }
        String[] cuvinte = vers.trim().split("\\s+");
        return cuvinte.length;
    }
    public int nr_vocale() {
        int vocale = 0;
        String vocaleString = "aeiouAEIOU";
        for (char c : vers.toCharArray()) {
            if (vocaleString.indexOf(c) != -1) {
                vocale++;
            }
        }
        return vocale;
    }

    public boolean terminare_sir(String sir) {
        return vers.endsWith(sir);
    }


    public String transf_majuscule() {
        return vers.toUpperCase();
    }

    public String get_vers() {
        return vers;
    }
}
