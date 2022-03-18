/* Plage.java                                                 DATE : 05/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package pereNoel;
/** 
 * Cet objet poss�de deux caract�ristiques repr�sentant respectivement
 * la borne inf�rieur et la borne sup�rieur d'une tranche d'�ge id�ale 
 * pour l'utilisation d'un jouet 
 * @author guillaume.medard
 */
public class Plage {

    private int plageInf;
    private int plageSup;

    /**
     * Constructeur de l'objet plage.
     * Le constructeur retrouve automatiquement la borne sup�rieure et inf�rieure
     * ind�pendament de l'ordre des variables passer en argument
     * @param plageInf age minimum id�al � l'utilisation du jouet
     * @param plageSup age maximal id�al � l'utilisation du jouet
     * @throws si les plages sont n�gative , car cela correspondrait a avoir un �ge n�gatif ce qui est absurde
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