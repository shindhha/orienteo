/* Plage.java                                                 DATE : 05/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package pereNoel;
/** TODO commenter la responsabilité de cette classe
 * @author guillaume.medard
 *
 */
public class Plage {

    private int plageInf;
    private int plageSup;

    /**
     * TODO commenter l'état initial atteint
     * @param plageInf
     * @param plageSup
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