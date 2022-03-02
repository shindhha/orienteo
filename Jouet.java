package orienteo;
public class Jouet {

    private int masse;
    private String nom;
    private int plagemin;
    private int plagesup;


    public Jouet(int masse, String nom, int plagesup , int plagemin) {

        this.masse = masse;
        this.nom = nom;
        this.plagemin = plagemin;
        this.plagesup = plagesup;
    }

    public String getName() {
        return this.nom;
    }

    public int getMasse() {
        return this.masse;
    }
}