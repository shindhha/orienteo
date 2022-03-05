/* Jouet.java                                                 DATE : 05/03/2022
 * INFO1 2021-2022, Iut Rodez 
 * pas de droit d'auteur ni de copyright
 */

package orienteo;
import orienteo.Plage.*;
/**
 * Représentation d'un Jouet sous la forme d'un objet java
 * cette objet possède des caractéristique comme :
 * - un nom 
 * - un poid 
 * - une Plage d'age idéale a son utilisation
 * @author Guillaume Medard
 */
public class Jouet {

    private int masse;
    private String nom;
    private Plage plageAge;

    /**
     * Constructeur de l'objet Jouet
     * @param masse la masse de l'objet
     * @param nom le nom de l'objet
     * @param plageAge la plage d'age idéale a son utilisation
     */
    public Jouet(int masse, String nom, Plage plageAge) {

        this.masse = masse;
        this.nom = nom;
        this.plageAge = plageAge;
    }
    /** @return le nom de l'objet */
    public String getName() {
        return this.nom;
    }
    /** @return la masse de l'objet */
    public int getMasse() {
        return this.masse;
    }
    /** @return la plage de l'objet */
    public Plage getPlage() {
        return this.plageAge;
    }
}