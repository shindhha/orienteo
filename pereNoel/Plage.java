/* Plage.java                                                 DATE : 05/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package pereNoel;
/** 
 * Cet objet possède deux caractéristiques représentant respectivement
 * la borne inférieur et la borne supérieur d'une tranche d'âge idéale 
 * pour l'utilisation d'un jouet 
 * @author guillaume.medard
 */
public class Plage {

    private int plageInf;
    private int plageSup;

    /**
     * Constructeur de l'objet plage.
     * Le constructeur retrouve automatiquement la borne supérieure et inférieure
     * indépendament de l'ordre des variables passer en argument
     * @param plageInf age minimum idéal à l'utilisation du jouet
     * @param plageSup age maximal idéal à l'utilisation du jouet
     * @throws si les plages sont négative , car cela correspondrait a avoir un âge négatif ce qui est absurde
     */
    public Plage(int plageInf,int plageSup) {
        super();
        
        if (plageInf < 0 || plageSup < 0) {
            throw new IllegalArgumentException();
        }
        this.plageInf = plageInf > plageSup ? plageSup : plageInf;
        this.plageSup = plageInf > plageSup ? plageInf : plageSup;
    }
   
}