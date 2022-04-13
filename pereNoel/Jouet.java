/* Jouet.java                                                 DATE : 05/03/2022
 * INFO1 2021-2022, Iut Rodez 
 * pas de droit d'auteur ni de copyright
 */

package pereNoel;
import pereNoel.Plage.*;
/**
 * ReprÃ©sentation d'un Jouet sous la forme d'un objet java
 * cette objet possÃ¨de des caractÃ©ristique comme :
 * - un nom 
 * - un poid 
 * - une Plage d'age idÃ©ale a son utilisation
 * @author Guillaume Medard
 */
public class Jouet {
   
    private static final int MAX_LENTGH_PATRONYME = 50;
    private int masse;
    private String nom;
    private Plage plageAge;

    /**
     * Constructeur de l'objet Jouet
     * @param masse la masse de l'objet
     * @param nom le nom de l'objet
     * @param plageAge la plage d'age idÃ©ale a son utilisation
     */
    public Jouet(String nom,int masse, Plage plageAge) {
        super();
        if (nom == null || nom.isBlank() || 
            nom.length() > MAX_LENTGH_PATRONYME || masse < 0) {
            throw new IllegalArgumentException();
        }
        
        this.masse = masse;
        this.nom = nom;
        this.plageAge = plageAge;
    }
    /** @return le nom de l'objet */
    public String getName() {
        return this.nom;
    }
    /** @return la masse de l'objet */
    public double getMasseKg() {
        return this.masse / 1000;
    }
    /** @return la plage de l'objet */
    public Plage getPlage() {
        return this.plageAge;
    }
    public String toString() {
        return this.getPlage().getPlageSup() == 0 ? 
               nom + " : " +  getMasseKg() + " kg, à partir de " 
               + plageAge.getPlageInf() + " jusqu'à " + plageAge.getPlageSup() :
               nom + " : " +  getMasseKg() + " kg, à partir de " 
               + plageAge.getPlageInf();
    }
}